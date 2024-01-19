package com.generation.app.service;

import java.util.List;
import com.generation.app.entity.OrderHasProduct;
import com.generation.app.compositeKey.OrderProductKey;

public interface OrderHasProductService {

	OrderHasProduct createOrderHasProduct(OrderHasProduct orderHasProduct);
	OrderHasProduct getOrderHasProductById(OrderProductKey id);
	List<OrderHasProduct> getAllOrderHasProducts();
	void deleteOrderHasProduct(OrderProductKey id);
}
