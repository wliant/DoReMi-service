package com.thesundaylunatics.service;

import java.util.List;

import com.thesundaylunatics.model.Customer;

public interface CustomerService {
	Customer save(Customer customer);
	List<Customer> list();
	void delete(Long id);
	Customer get(Long id);
	
}
