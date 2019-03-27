package com.thesundaylunatics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.service.CustomerService;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GET
	public List<Customer> listCustomers() {
		return customerService.list();
	}
	
	@Path("/{id}")
	@GET
	public Customer getCustomer(@PathParam(value = "id") Long id) {
		return customerService.get(id);
	}
	
	@POST
	public Customer saveCustomer(Customer customer) {
		return customerService.save(customer);
	}
}
