package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
    public User getUserById(Long userId) {
    	boolean exist = userRepository.existsById(userId);
    	if(!exist) {
    		throw new IllegalStateException("User with user id "+userId+" doesn't exist");
    	}
    	Optional<User> optionalUser =  userRepository.findById(userId);
    	return optionalUser.get();
    }

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		boolean exist = userRepository.existsById(userId);
    	if(!exist) {
    		throw new IllegalStateException("User with user id "+userId+" doesn't exist");
    	}
		userRepository.deleteById(userId);
	}
}
