package com.thesundaylunatics.dao;

import com.thesundaylunatics.model.Order;
import com.thesundaylunatics.model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemDao extends CrudRepository<OrderLineItem, Long> {
}
