package com.thesundaylunatics.service.impl;

import com.thesundaylunatics.dao.SupplierDao;
import com.thesundaylunatics.model.Supplier;
import com.thesundaylunatics.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	@Override
	public Supplier save(Supplier supplier) {
		supplier.setId(null);
		return supplierDao.save(supplier);
	}

	@Override
	public List<Supplier> list() {
		List<Supplier> list = new ArrayList<>();
		supplierDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(Long id) {
		supplierDao.delete(id);
	}

	@Override
	public Supplier get(Long id) {
		return supplierDao.findOne(id);
	}

}
