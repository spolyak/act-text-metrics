package com.stevepolyak.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class TextController {
 
    @RequestMapping("/text")
    public String viewTextMetrics(Map<String, Object> map) {
        return "welcome";
    }
 
}