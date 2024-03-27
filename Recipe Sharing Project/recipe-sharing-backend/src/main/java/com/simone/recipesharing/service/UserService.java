package com.simone.recipesharing.service;

import com.simone.recipesharing.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws Exception;
	public User findUserByJwt(String jwt) throws Exception;

}
