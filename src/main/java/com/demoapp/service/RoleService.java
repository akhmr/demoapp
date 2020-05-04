package com.demoapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.demoapp.entity.Role;
import com.demoapp.entity.User;
import com.demoapp.entity.UserRole;
import com.demoapp.entity.repo.RoleRepo;
import com.demoapp.entity.repo.UserRepo;
import com.demoapp.entity.repo.UserRoleRepo;
import com.demoapp.request.CreateRoleRequest;
import com.demoapp.request.UserRoleRequest;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Transactional
	public Boolean createRole(CreateRoleRequest request) {
		for(String url:request.getAllowedUrls()) {
			Role role = new Role();
			role.setServiceName("web");
			role.setRole(role.getRole());
			role.setUrl(url);
			roleRepo.save(role);
		}
		return true;
	}

	@Transactional
	public Boolean mapRoleToUser(UserRoleRequest request) {
		
		User user =userRepo.findByCode(request.getUserCode());
		if( user== null ) {
			throw new RuntimeException("User does not exist");
		}
		
		List<Role> roles =roleRepo.findByRole(request.getRole());
		if( CollectionUtils.isEmpty(roles)) {
			throw new RuntimeException("Role does not exist");
		}
		
		UserRole userRole = new UserRole();
		userRole.setUserCode(request.getUserCode());
		userRole.setRole(request.getRole());
		userRoleRepo.save(userRole);
		
		return true;
	}
	

}
