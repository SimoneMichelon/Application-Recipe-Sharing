package com.simone.recipesharing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simone.recipesharing.configuration.JwtProvider;
import com.simone.recipesharing.model.User;
import com.simone.recipesharing.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional<User> opt = userRepository.findById(userId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else throw new Exception("User not found with id " + userId);
	}

	@Override
	public User findUserByJwt(String jwt) throws Exception {
		
		String email = jwtProvider.getEmailFromJwtToken(jwt);
		
		if(email == null) {
			throw new Exception("Provide a valid jwt token");
		}
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new Exception("User not found with email " + email);
		}
		
		return user;
	}

	
}
