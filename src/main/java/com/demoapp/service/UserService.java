package com.demoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.entity.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

}
