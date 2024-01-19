package com.generation.app.service;

import com.generation.app.entity.Privilege;

public interface PrivilegeService {

	Privilege getPrivilegeById(Long id);
	Privilege createPrivilege(Privilege privilege);
	
}
