package com.demoapp.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Long>{
	
	List<UserRole> findByUserCode(String userCode);
	

}
