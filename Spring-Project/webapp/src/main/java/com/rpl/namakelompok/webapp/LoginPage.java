package com.rpl.namakelompok.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPage {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
}
