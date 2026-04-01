package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

import dto.LoginDto;



@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	 @Autowired
	    private PasswordEncoder encoder;

	    public User register(User user) {
      user.setRole("User");
	        return userRepo.save(user);
	    }
	    
	    public String login(LoginDto dto) {

	        User user = userRepo.findByUsername(dto.getUsername());

	        if (user == null) {
	            return "User not found";
	        }

	        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
	            return "Invalid password";
	        }

	        return "Login Successful";
	    }

}
