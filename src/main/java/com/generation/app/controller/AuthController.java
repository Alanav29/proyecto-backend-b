package com.generation.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.app.dto.UserDto;
import com.generation.app.entity.User;
import com.generation.app.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping(value = "login")
    public ResponseEntity<UserDto> login(@RequestBody User request){
    	UserDto userLogged = authService.login(request);
    	return new ResponseEntity<>( userLogged, HttpStatus.OK);
        
    }

    @PostMapping(value = "register")
    public ResponseEntity<UserDto> register(@RequestBody User request)
    {
    	UserDto userRegistered = authService.register(request);
    	return new ResponseEntity<>( userRegistered, HttpStatus.CREATED);
    }
}
