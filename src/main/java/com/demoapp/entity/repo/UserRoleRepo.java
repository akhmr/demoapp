package com.demoapp.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Long>{
	

}
