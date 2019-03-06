package com.thesundaylunatics.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thesundaylunatics.model.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {
}
