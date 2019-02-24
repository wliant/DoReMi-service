package com.thesundaylunatics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.service.CustomerService;

@RestController
@RequestMapping(value="/rest2/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> listCustomers() {
		return customerService.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable(value = "id") Long id) {
		return customerService.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}
