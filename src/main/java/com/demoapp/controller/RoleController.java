package com.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoapp.request.CreateRoleRequest;
import com.demoapp.response.Response;
import com.demoapp.service.RoleService;

@RequestMapping(path = "/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	public Response<Boolean>  createRole(@RequestBody CreateRoleRequest request) {
		return new Response(roleService.createRole(request));
	}
	
}
