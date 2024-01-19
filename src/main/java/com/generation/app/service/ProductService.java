package com.generation.app.service;

import java.util.List;
import com.generation.app.entity.Product;

public interface ProductService {
	Product getProductById(Long id);
	Product createProduct(Product product);
	List<Product> getAllProducts();
	Product updateProduct(Product product, Long id);
	Product deleteProduct(Long id);
}

