package com.momo.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

	@GetMapping
	public String greet(@RequestParam(value = "name", defaultValue = "annoymous") String name, Model model) {

		String msg = String.format("Hi, %s welcome to the Spring World!", name);

		model.addAttribute("greeting", msg);

		return "welcome";
	}
}
