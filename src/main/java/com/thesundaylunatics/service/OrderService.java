package com.thesundaylunatics.service;

import java.util.List;

import com.thesundaylunatics.model.Order;

public interface OrderService {
	Order save(Order order);
	List<Order> list();
	List<Order> approvedList();
	void delete(Long id);
	Order get(Long id);
	
}

