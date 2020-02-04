package org.owasp.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsecureLogin {

    @PostMapping("/InsecureLogin/task")
    @ResponseBody
    public boolean completed(@RequestParam String username, @RequestParam String password){
        if(username.toString().equals("CaptainJack") && password.toString().equals("BlackPearl")){
            return true;
        }else{
            return false;
        }
    }
}
