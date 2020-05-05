package com.demoapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.constant.LoginBy;
import com.demoapp.entity.Role;
import com.demoapp.entity.User;
import com.demoapp.entity.UserRole;
import com.demoapp.entity.UserToken;
import com.demoapp.entity.repo.RoleRepo;
import com.demoapp.entity.repo.UserRepo;
import com.demoapp.entity.repo.UserRoleRepo;
import com.demoapp.entity.repo.UserTokenRepo;
import com.demoapp.model.UserDto;
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
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Autowired
	private RoleRepo roleRepo;

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

	
	public UserDto getUserByToken(String token){
		UserToken userToken =userTokenRepo.findByToken(token);
		if( userToken == null) {
			throw new RuntimeException("Token is not valid");
		}
		
		if( userToken.getTokenExpairyTime() < System.currentTimeMillis()) {
			throw new RuntimeException("Token has been expired.Please login again");
		}
		
		User user= userRepo.findByCode(userToken.getUsercode());
		
		UserDto userDto = new UserDto();
		userDto.setEmail(userDto.getEmail());
		userDto.setPhoneNo(userDto.getPhoneNo());
		userDto.setCode(userDto.getCode());
		userDto.setName(userDto.getName());
		return userDto;
		
	}
	
	public Set<String> getUserPermission(String userCode) {

		List<UserRole> userRolesMapping = userRoleRepo.findByUserCode(userCode);
		List<String>  userRoles= userRolesMapping.stream().map(u -> u.getRole()).collect(Collectors.toList());
		
		List<Role> roles =roleRepo.findByRoleIn(userRoles);
		
		Set<String> allowedUrl = new HashSet<>();
		for(Role  role:roles) {
			allowedUrl.add(role.getUrl());
		}
		
		return allowedUrl;

	}
}
