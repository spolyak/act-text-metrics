package com.stevepolyak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
 
@Controller
public class WelcomeController {
 
    @RequestMapping("/welcome")
    public String viewStandards(Map<String, Object> map) {
        return "welcome";
    }
 
}