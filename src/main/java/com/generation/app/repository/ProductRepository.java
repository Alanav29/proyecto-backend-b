package com.generation.app.repository;


import java.util.Optional;
import com.generation.app.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
	Optional<Product> findById(Long id);
	Optional<Product> findByTitle(String title);
	Iterable<Product> findAllByActive(Boolean active);
}

