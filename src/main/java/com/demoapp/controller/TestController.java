package com.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.annotation.Authenticated;

@RestController
@RequestMapping(path = "/testing")
public class TestController {
	
	@GetMapping(value="/test")
	@Authenticated(roleRequired = true)
	public String test() {
		return "success";
	}

}
