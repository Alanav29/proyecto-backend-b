package com.generation.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.app.entity.Privilege;
import com.generation.app.service.PrivilegeService;

@RestController
@RequestMapping("api/v1/privileges")
public class PrivilegeController {
	@Autowired
	PrivilegeService privilegeService;
	
	@PostMapping
	ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege){
		Privilege newPrivilege = privilegeService.createPrivilege(privilege);
		return new ResponseEntity<>( newPrivilege, HttpStatus.CREATED);
	}
}
