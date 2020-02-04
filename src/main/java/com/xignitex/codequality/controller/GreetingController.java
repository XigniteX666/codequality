package com.xignitex.codequality.controller;

import com.xignitex.codequality.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;

public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name){
        String firstName = "Oskar";
        int age = 54;
        if(firstName.equals(age)){
            System.out.printf("Dit kan niet!");
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name) );
    }

    @GetMapping("/login")
    public boolean login(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
        String query = "SELECT * from users where username = " + username + " AND password = " + password;

        String url = "jdbc:msql://localhost/Demo";
        Connection conn;

        try {
            conn = DriverManager.getConnection(url,"","");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            conn.close();
            while ( rs.next() ) {
                String lastName = rs.getString("Lname");
                System.out.println(lastName);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return false;
    }
}
