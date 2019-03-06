package com.thesundaylunatics.service.impl;

import com.thesundaylunatics.dao.ProductInventoryDao;
import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.model.ProductInventory;
import com.thesundaylunatics.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "inventoryService")
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ProductInventoryDao productInventoryDao;
	@Override
	public ProductInventory save(ProductInventory productInventory) {
		productInventory.setId(null);
		return productInventoryDao.save(productInventory);
	}

	@Override
	public List<ProductInventory> list() {
		List<ProductInventory> list = new ArrayList<>();
		productInventoryDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(Long id) {
		productInventoryDao.delete(id);
	}

	@Override
	public ProductInventory get(Long id) {
		return productInventoryDao.findOne(id);
	}

}
