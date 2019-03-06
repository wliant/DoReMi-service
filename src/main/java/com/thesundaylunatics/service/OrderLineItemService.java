package com.thesundaylunatics.service;

import com.thesundaylunatics.model.OrderLineItem;

import java.util.List;

public interface OrderLineItemService {
	OrderLineItem save(OrderLineItem orderLineItem);
	List<OrderLineItem> list();
	void delete(Long id);
	OrderLineItem get(Long id);
	
}

