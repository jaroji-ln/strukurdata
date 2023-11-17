package com.rpl.namakelompok.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployersPage {
    @GetMapping("/employers")
    public String login(){
        return "employers";
    }
}
