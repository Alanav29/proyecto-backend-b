package com.generation.app.serviceImpl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.app.dto.UserDto;
import com.generation.app.entity.User;
import com.generation.app.jwt.JwtService;
import com.generation.app.repository.UserRepository;
import com.generation.app.service.AuthService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userServiceImpl;

    public UserDto login(User request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByEmail(request.getUsername()).orElseThrow();
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        
        String token=jwtService.getToken(user);
        
        return userServiceImpl.userToUserDto(existingUser.get(), token);

    }

    public UserDto register(User request) {
    	User user = new User();
    	user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode( request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setId(null);
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setPrivilege(null);
        
        String token = jwtService.getToken(user);

        return userServiceImpl.createUser(user, token);

        
        
    }

}
