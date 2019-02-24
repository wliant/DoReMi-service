package com.thesundaylunatics.service;

import java.util.List;

import com.thesundaylunatics.model.Product;

public interface ProductService {
	Product save(Product product);
	List<Product> list();
	void delete(Long id);
	Product get(Long id);
	
}

