package com.generation.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.generation.app.entity.Privilege;


public interface PrivilegeRepository extends CrudRepository<Privilege, Long>{
	Optional<Privilege> findById(Long id);
	Optional<Privilege> findByPrivilege(String privilege);
}
