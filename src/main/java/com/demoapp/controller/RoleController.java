package com.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.request.CreateRoleRequest;
import com.demoapp.response.Response;
import com.demoapp.service.RoleService;

@RequestMapping(path = "/roles")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("")
	public Response<Boolean>  createRole(@RequestBody CreateRoleRequest request) {
		return new Response(roleService.createRole(request));
	}
	
}
