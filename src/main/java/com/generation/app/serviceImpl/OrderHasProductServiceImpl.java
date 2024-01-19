package com.generation.app.serviceImpl;

import java.util.List;
import com.generation.app.entity.OrderHasProduct;
import com.generation.app.compositeKey.OrderProductKey;
import com.generation.app.repository.OrderHasProductRepository;
import com.generation.app.service.OrderHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHasProductServiceImpl implements OrderHasProductService {

	@Autowired
	OrderHasProductRepository orderHasProductRepository;
	
	@Override
	public OrderHasProduct createOrderHasProduct(OrderHasProduct orderHasProduct) {
		return orderHasProductRepository.save(orderHasProduct);
	}

	@Override
	public OrderHasProduct getOrderHasProductById(OrderProductKey id) {
		return orderHasProductRepository.findById(id)
					.orElseThrow( ()-> new IllegalStateException("Order-Product does not exist with id " + id));
	}
		
	@Override
	public List<OrderHasProduct> getAllOrderHasProducts() {
		return (List<OrderHasProduct>) orderHasProductRepository.findAll();
	}

	@Override
	public void deleteOrderHasProduct(OrderProductKey id) {
//		OrderHasProduct existingOrderHasProduct = getOrderHasProductById(id);
//		orderHasProductRepository.delete(existingOrderHasProduct);
	}
}
