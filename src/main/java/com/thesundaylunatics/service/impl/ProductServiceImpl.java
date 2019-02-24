package com.thesundaylunatics.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesundaylunatics.dao.ProductDao;
import com.thesundaylunatics.model.Product;
import com.thesundaylunatics.service.ProductService;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	@Override
	public Product save(Product product) {
		product.setId(null);
		return productDao.save(product);
	}

	@Override
	public List<Product> list() {
		List<Product> list = new ArrayList<>();
		productDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(Long id) {
		productDao.delete(id);
	}

	@Override
	public Product get(Long id) {
		return productDao.findOne(id);
	}

}
