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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Api(value = "Customer resource Version 1", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GET
	@ApiOperation(nickname = "", value = "Service to get customers", notes = "get all customers", response = Customer.class, tags = {
			"CustomerService" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Response ok", response = Customer.class),
			@ApiResponse(code = 401, message = "Un authorized", response = Void.class) })
	public List<Customer> listCustomers() {
		return customerService.list();
	}

	@Path("/{id}")
	@GET
	@ApiOperation(nickname = "", value = "Service to get customers", notes = "get all customers", response = Customer.class, tags = {
			"CustomerService" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Response ok", response = Customer.class),
			@ApiResponse(code = 401, message = "Un authorized", response = Void.class) })
	public Customer getCustomer(@PathParam(value = "id") Long id) {
		return customerService.get(id);
	}

	@POST
	@ApiOperation(nickname = "", value = "Service to get customers", notes = "get all customers", response = Customer.class, tags = {
			"CustomerService" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Response ok", response = Customer.class),
			@ApiResponse(code = 401, message = "Un authorized", response = Void.class) })
	public Customer saveCustomer(Customer customer) {
		return customerService.save(customer);
	}
}
