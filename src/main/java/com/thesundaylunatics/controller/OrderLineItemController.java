package com.thesundaylunatics.controller;

import com.thesundaylunatics.model.OrderLineItem;
import com.thesundaylunatics.service.OrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest2")
public class OrderLineItemController {
	@Autowired
	private OrderLineItemService orderLineItemService;

	@RequestMapping(value="/orderLineItems", method = RequestMethod.GET)
	public List<OrderLineItem> listOrderLineItem() {
		return orderLineItemService.list();
	}

	@RequestMapping(value = "/orderLineItems/{id}", method = RequestMethod.GET)
	public OrderLineItem getOrderLineItem(@PathVariable(value = "id") Long id) {
		return orderLineItemService.get(id);
	}
	
	@RequestMapping(value = "/orderLineItems", method = RequestMethod.POST)
	public OrderLineItem saveOrderLineIterm(@RequestBody OrderLineItem orderLineItem) {
		return orderLineItemService.save(orderLineItem);
	}
}
