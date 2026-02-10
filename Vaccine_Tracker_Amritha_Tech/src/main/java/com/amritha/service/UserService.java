package com.amritha.service;

import com.amritha.entity.User;

public interface UserService {
	
	User login(String email, String password);
	
	User getUserById(Long id);
}
