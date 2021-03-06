package com.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.request.CreateUserRequest;
import com.demoapp.request.UserLoginRequest;
import com.demoapp.request.UserRoleRequest;
import com.demoapp.response.CreateUserResponse;
import com.demoapp.response.Response;
import com.demoapp.service.RoleService;
import com.demoapp.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	

	@PostMapping("")
	public Response<CreateUserResponse> createUserRequest(@RequestBody CreateUserRequest request) {
		return new Response(userService.createUserRequest(request));
	}
	
	@PostMapping("/login")
	public Response<CreateUserResponse> login(@RequestBody UserLoginRequest request) {
		return new Response(userService.login(request));
	}
	
	@PostMapping("/roles")
	public Response<Boolean> mapRoleToUser(@RequestBody UserRoleRequest request) {
		return new Response(roleService.mapRoleToUser(request));
	}
	
	

}
