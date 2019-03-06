package com.thesundaylunatics.service;

import com.thesundaylunatics.model.ProductInventory;
import com.thesundaylunatics.model.Supplier;

import java.util.List;

public interface SupplierService {

	Supplier save(Supplier supplier);
	List<Supplier> list();
	void delete(Long id);

	Supplier get(Long id);
	
}
