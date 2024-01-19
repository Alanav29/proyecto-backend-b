package com.generation.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.generation.app.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
	 Optional<User> findByEmail(String email);
}
