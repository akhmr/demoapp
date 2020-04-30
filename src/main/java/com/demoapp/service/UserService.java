package com.demoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.entity.repo.UserRepo;
import com.demoapp.response.CreateUserRequest;
import com.demoapp.response.CreateUserResponse;
import com.demoapp.response.Response;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public Response<CreateUserResponse> createUserRequest(CreateUserRequest request) {
		
		return null;
		
	}

}
