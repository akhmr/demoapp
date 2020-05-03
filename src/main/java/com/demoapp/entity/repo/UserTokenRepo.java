package com.demoapp.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.UserToken;

@Repository
public interface UserTokenRepo extends JpaRepository<UserToken,Long>{

}
