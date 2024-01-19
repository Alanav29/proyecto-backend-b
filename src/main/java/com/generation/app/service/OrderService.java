package com.generation.app.service;

import java.util.List;

import com.generation.app.entity.Order;

public interface OrderService {
	Order getOrderById(Long id);
	Order createOrder(Order order);
	List<Order> getAllOrders();
	void deleteOrder(Long id);
}
