package com.generation.app.controller;

import java.util.List;

import com.generation.app.entity.OrderHasProduct;
import com.generation.app.compositeKey.OrderProductKey;
import com.generation.app.service.OrderHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/orders-has-products")
public class OrderHasProductController {

	@Autowired
	OrderHasProductService orderHasProductService;
	@Autowired
	OrderProductKey idOrderProduct;
	
	@GetMapping
	ResponseEntity< List<OrderHasProduct> > getAllOrdersHasProducts(){
		List<OrderHasProduct> orders = orderHasProductService.getAllOrderHasProducts();
		return new ResponseEntity<>(orders, HttpStatus.OK );
	}
	
	@GetMapping("/{idOrder}/{idProduct}")
	ResponseEntity<OrderHasProduct> getOrderById(
			@PathVariable("idOrder") Long idOrder, 
			@PathVariable("idProduct") Long idProduct
			) {
		idOrderProduct.setOrderId(idOrder);
		idOrderProduct.setProductId(idProduct);
		OrderHasProduct orderHasProduct = orderHasProductService.getOrderHasProductById(idOrderProduct);
		return new ResponseEntity<>(orderHasProduct, HttpStatus.OK );
	}
	
	@PostMapping
	ResponseEntity<OrderHasProduct> createOrder(@Validated @RequestBody OrderHasProduct orderHasProduct) {	
		OrderHasProduct newOrderHasProduct = orderHasProductService.createOrderHasProduct(orderHasProduct);
		return new ResponseEntity<>(newOrderHasProduct, HttpStatus.CREATED );
	}
}
