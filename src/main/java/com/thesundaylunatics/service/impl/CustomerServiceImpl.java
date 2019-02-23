package com.thesundaylunatics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesundaylunatics.dao.CustomerDao;
import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.service.CustomerService;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	@Override
	public Customer save(Customer customer) {
		customer.setId(null);
		return customerDao.save(customer);
	}

	@Override
	public List<Customer> list() {
		List<Customer> list = new ArrayList<>();
		customerDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(Long id) {
		customerDao.delete(id);
	}

	@Override
	public Customer get(Long id) {
		return customerDao.findOne(id);
	}

}
