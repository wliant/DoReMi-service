package com.thesundaylunatics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesundaylunatics.model.Product;
import com.thesundaylunatics.service.ProductService;

@RestController
@RequestMapping(value="/rest2")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public List<Product> listProducts() {
		return productService.list();
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable(value = "id") Long id) {
		return productService.get(id);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product order) {
		return productService.save(order);
	}
}

