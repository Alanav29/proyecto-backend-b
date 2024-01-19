package com.generation.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.app.entity.Privilege;
import com.generation.app.repository.PrivilegeRepository;
import com.generation.app.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	PrivilegeRepository privilegeRepository;

	@Override
	public Privilege getPrivilegeById(Long id) {
		return privilegeRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Privilege does not exist with id " + id));
	}

	@Override
	public Privilege createPrivilege(Privilege privilege) {
		Optional<Privilege> existingPrivilege = privilegeRepository.findByPrivilege(privilege.getPrivilege());
		if( existingPrivilege.isPresent()) throw new IllegalStateException("Privilege already exist");
		else privilege.setId(null);
			
		return  privilegeRepository.save(privilege);
	}

}
