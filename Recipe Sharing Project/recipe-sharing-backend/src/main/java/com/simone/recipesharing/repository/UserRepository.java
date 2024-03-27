package com.simone.recipesharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simone.recipesharing.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);

}
