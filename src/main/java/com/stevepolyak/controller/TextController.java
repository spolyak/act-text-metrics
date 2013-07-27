package com.stevepolyak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stevepolyak.model.Text;
import com.stevepolyak.service.TextMetricsService;

import java.util.Map;

@Controller
public class TextController {

    @Autowired
    private TextMetricsService tmService;

    @RequestMapping("/")
    public String listPeople(Map<String, Object> map) {

        map.put("text", new Text());

        return "people";
    }

    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    public String computeText(@ModelAttribute("text") Text text, BindingResult result) {

        tmService.compute(text);

        return "redirect:/text/";
    }
}