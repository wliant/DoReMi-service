package com.thesundaylunatics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesundaylunatics.model.Order;
import com.thesundaylunatics.service.OrderService;

@RestController
@RequestMapping(value="/rest2")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public List<Order> listOrder() {
		return orderService.list();
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable(value = "id") Long id) {
		return orderService.get(id);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order saveOrder(@RequestBody Order order) {
		return orderService.save(order);
	}
}
