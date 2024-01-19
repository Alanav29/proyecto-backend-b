package com.generation.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.app.dto.UserDto;
import com.generation.app.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PutMapping
	ResponseEntity<UserDto> updateUserPrivilege(@RequestBody UserDto user) {
		UserDto userUpdated = userService.updateUserPrivilege(user);
		return new ResponseEntity<>( userUpdated, HttpStatus.OK);
	}

}
