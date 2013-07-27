package com.stevepolyak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/text")
	public String viewText(Map<String, Object> map) {
		map.put("text", new Text());
		return "text";
	}

	@RequestMapping(value = "/compute", method = RequestMethod.GET)
	public String computeGet(@ModelAttribute("text") Text text,
			Map<String, Object> map) {
		map.put("text", new Text());
		return "text";
	}

	@RequestMapping(value = "/compute", method = RequestMethod.POST)
	public String compute(@ModelAttribute("text") Text text,
			Map<String, Object> map) {

		tmService.compute(text);
		map.put("text", text);
		return "text";
	}

}