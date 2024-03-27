package com.simone.recipesharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.simone.recipesharing.model.User;
import com.simone.recipesharing.service.UserService;

@RestController		
public class UserController {

	@Autowired
	private UserService userService;
	
	// @Autowired
	// private UserRepository userRepository;
	
	@GetMapping("/api/users/profile")
	public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwt(jwt);
		return user;
	}
	
	
	
	

	// @PostMapping("/users")
	// public User createUser(@RequestBody User user) throws Exception {
	// 	User userExists = userRepository.findByEmail(user.getEmail());
	// 	if(userExists != null) {
	// 		throw new Exception("Email already used : " + userExists.getEmail());
	// 	}

	// 	User savedUser = userRepository.save(user);

	// 	return savedUser;
	// }
	
//	@DeleteMapping("/users/{userId}")
//	public String deleteUser(@PathVariable Long userId) throws Exception {
//		
//		userRepository.deleteById(userId);
//		
//		return "User deleted successfully";
//	} 
//	
	// @GetMapping("/users")
	// public List<User> getAllUser() throws Exception {
		
	// 	List<User> users = userRepository.findAll();
		
	// 	return users;
	// } 
 

	//	@GetMapping
	//	public User findUserByEmail(String email) throws Exception {
	//		User user = userRepository.findByEmail(email);
	//		if(user == null) {
	//			throw new Exception("User not found with email " + email);
	//		}
	//		
	//		return user;
	//	}
}
