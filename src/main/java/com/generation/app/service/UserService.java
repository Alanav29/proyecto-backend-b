package com.generation.app.service;

import com.generation.app.dto.UserDto;
import com.generation.app.entity.User;

public interface UserService {
	
	UserDto createUser(User user, String token);
	UserDto updateUserPrivilege(UserDto user);
	
	
}

