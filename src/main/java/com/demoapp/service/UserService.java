package com.demoapp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.constant.LoginBy;
import com.demoapp.entity.User;
import com.demoapp.entity.UserToken;
import com.demoapp.entity.repo.UserRepo;
import com.demoapp.entity.repo.UserTokenRepo;
import com.demoapp.request.CreateUserRequest;
import com.demoapp.request.UserLoginRequest;
import com.demoapp.response.CreateUserResponse;
import com.demoapp.response.UserLoginResponse;
import com.demoapp.util.TokenUtil;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserTokenRepo userTokenRepo;

	public CreateUserResponse createUserRequest(CreateUserRequest request) {

		return Optional.of(request).map(this::convertToUser).map(userRepo::save).map(CreateUserResponse::of)
				.orElse(null);
	}

	public User convertToUser(CreateUserRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setPhoneNo(request.getPhoneNo());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setCode(TokenUtil.generateUserCode());
		return user;

	}

	@Transactional
	public UserLoginResponse login(UserLoginRequest request) {

		User user = null;
		if (request.getLoginBy().equals(LoginBy.Email)) {
			user = userRepo.findByEmail(request.getEmailOrPhoneNo());
		} else {
			user = userRepo.findByPhoneNo(request.getEmailOrPhoneNo());

		}

		if (user != null && user.getPassword().contentEquals(request.getPassword())) {
			String token = TokenUtil.generateToken();
			UserToken userToken = new UserToken();
			userToken.setUsercode(user.getCode());
			userToken.setToken(token);
			userToken.setTokenExpairyTime(System.currentTimeMillis()+2592000000l);
			userTokenRepo.save(userToken);
			return new UserLoginResponse(token);
		}
		throw new RuntimeException("Please enter correct password");
	}

}
