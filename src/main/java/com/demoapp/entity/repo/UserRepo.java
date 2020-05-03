package com.demoapp.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	User findByEmail(String emailOrPhoneNo);

	User findByPhoneNo(String emailOrPhoneNo);

}
