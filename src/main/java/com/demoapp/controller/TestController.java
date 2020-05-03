package com.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.annotation.Authenticated;

@RestController
public class TestController {
	
	@GetMapping("test")
	@Authenticated(roleRequired = true)
	public String test() {
		return "success";
	}

}
