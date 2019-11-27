package com.dev.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

	@GetMapping("index")
	public String gotoIndex() {
		return "index";
	}
	
	@GetMapping("index/*")
	public String gotoAllIndex() {
		return "index";
	}
}
