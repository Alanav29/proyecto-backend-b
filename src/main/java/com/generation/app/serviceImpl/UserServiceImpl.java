package com.generation.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.app.dto.UserDto;
import com.generation.app.entity.Privilege;
import com.generation.app.entity.User;
import com.generation.app.repository.PrivilegeRepository;
import com.generation.app.repository.UserRepository;
import com.generation.app.service.PrivilegeService;
import com.generation.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PrivilegeRepository privilegeRepository;
	@Autowired
	PrivilegeService privilegeService;

	@Override
	public UserDto createUser(User user, String token) {
		user.setId(null);
		Optional<Privilege> existingPrivilege = privilegeRepository.findByPrivilege("user");
		
		if( existingPrivilege.isPresent()) user.setPrivilege(existingPrivilege.get());
		else {
			Privilege userPrivilege = privilegeService.createPrivilege(new Privilege("user"));
			user.setPrivilege(userPrivilege);
			}
		
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if( existingUser.isPresent()) throw new IllegalStateException("User already exist");
		
		
		User newUser = userRepository.save( user );
		return userToUserDto(newUser,token);
	}

	@Override
	public UserDto updateUserPrivilege(UserDto user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if( existingUser.isPresent()) {
			Optional<Privilege> existingPrivilege = privilegeRepository.findByPrivilege(user.getPrivilege().getPrivilege());
			if( existingPrivilege.isPresent()) existingUser.get().setPrivilege(existingPrivilege.get());;
		}
		User userUpdated = userRepository.save(existingUser.get());
		return userToUserDto(userUpdated, user.getToken());
	}

	
	public UserDto userToUserDto(User user , String token) {
		UserDto userDto = new UserDto();
		userDto.setId( user.getId() );
		userDto.setFirstName(  user.getFirstName() );
		userDto.setLastName(  user.getLastName() );
		userDto.setEmail( user.getEmail() );
		userDto.setPrivilege(user.getPrivilege());
		userDto.setToken(token);
		return userDto;
	}


}
