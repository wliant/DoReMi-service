package com.thesundaylunatics.service.impl;

import com.thesundaylunatics.dao.OrderLineItemDao;
import com.thesundaylunatics.model.OrderLineItem;
import com.thesundaylunatics.service.OrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "orderLineItemService")
public class OrderLineItemServiceImpl implements OrderLineItemService {

	@Autowired
	private OrderLineItemDao orderLineItemDao;

	@Override
	public OrderLineItem save(OrderLineItem orderLineItem) {
		orderLineItem.setId(null);
		return orderLineItemDao.save(orderLineItem);
	}

	@Override
	public List<OrderLineItem> list() {
		List<OrderLineItem> list = new ArrayList<>();
		orderLineItemDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	@Override
	public void delete(Long id) {
		orderLineItemDao.delete(id);
	}

	@Override
	public OrderLineItem get(Long id) {
		return orderLineItemDao.findOne(id);
	}

}
