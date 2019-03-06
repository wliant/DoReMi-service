package com.thesundaylunatics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesundaylunatics.dao.OrderDao;
import com.thesundaylunatics.model.Order;
import com.thesundaylunatics.service.OrderService;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	@Override
	public Order save(Order product) {
		product.setId(null);
		return orderDao.save(product);
	}

	@Override
	public List<Order> list() {
		List<Order> list = new ArrayList<>();
		orderDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public List<Order> approvedList() {
		return StreamSupport.stream(orderDao.findAll().spliterator(), false)
				.filter(order->order.isApproved())
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		orderDao.delete(id);
	}

	@Override
	public Order get(Long id) {
		return orderDao.findOne(id);
	}

}
