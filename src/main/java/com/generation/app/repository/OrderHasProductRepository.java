package com.generation.app.repository;

import com.generation.app.entity.OrderHasProduct;
import com.generation.app.compositeKey.OrderProductKey;
import org.springframework.data.repository.CrudRepository;

public interface OrderHasProductRepository extends CrudRepository<OrderHasProduct, OrderProductKey>{

}
