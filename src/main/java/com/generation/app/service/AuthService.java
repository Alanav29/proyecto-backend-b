package com.generation.app.service;

import com.generation.app.dto.UserDto;
import com.generation.app.entity.User;


public interface AuthService {
	UserDto login(User user);
	UserDto register(User user);
}
