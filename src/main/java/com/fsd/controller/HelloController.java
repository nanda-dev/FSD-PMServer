package com.fsd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello, this is the Backend API Server for Project Manager SPA Application!";
	}

}
