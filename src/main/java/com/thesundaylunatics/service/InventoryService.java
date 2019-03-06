package com.thesundaylunatics.service;

import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.model.ProductInventory;

import java.util.List;

public interface InventoryService {

	ProductInventory save(ProductInventory productInventory);
	List<ProductInventory> list();
	void delete(Long id);
	ProductInventory get(Long id);
	
}
