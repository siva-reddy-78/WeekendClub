package com.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String homePage()
	{
		return "home";
	}
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
}