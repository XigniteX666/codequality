package com.xignitex.codequality.controller;

import com.xignitex.codequality.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name){
        String firstName = "Oskar";
        int age = 54;
        if(firstName.equals(age)){
            System.out.printf("Dit kan niet");
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name) );
    }
}
