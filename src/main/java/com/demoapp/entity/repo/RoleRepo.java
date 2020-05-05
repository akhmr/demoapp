package com.demoapp.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long>{

	List<Role> findByRoleIn(List<String> roles);

}
