package com.amritha.service;

import org.springframework.stereotype.Service;

import com.amritha.entity.User;
import com.amritha.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user; // success
    }

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Invalid id"));
	}

}
