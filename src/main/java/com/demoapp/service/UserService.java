package com.demoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.entity.User;
import com.demoapp.entity.repo.UserRepo;
import com.demoapp.request.CreateUserRequest;
import com.demoapp.request.UserLoginRequest;
import com.demoapp.response.CreateUserResponse;
import com.demoapp.response.UserLoginResponse;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public CreateUserResponse createUserRequest(CreateUserRequest request) {

		return Optional.of(request)
				.map(this::convertToUser)
				.map(userRepo::save)
				.map(CreateUserResponse::of)
				.orElse(null);
	}

	public User convertToUser(CreateUserRequest request) {
		return new User();

	}

	public UserLoginResponse login(UserLoginRequest request) {
		return null;
	}

	

}
