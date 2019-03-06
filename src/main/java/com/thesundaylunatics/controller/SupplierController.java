package com.thesundaylunatics.controller;

import com.thesundaylunatics.model.Product;
import com.thesundaylunatics.model.Supplier;
import com.thesundaylunatics.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest2")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value="/suppliers", method = RequestMethod.GET)
	public List<Supplier> listSupplier() {
		return supplierService.list();
	}

	@RequestMapping(value = "/suppliers/{id}", method = RequestMethod.GET)
	public Supplier getSupplier(@PathVariable(value = "id") Long id) {
		return supplierService.get(id);
	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.POST)
	public Supplier saveSupplier(@RequestBody Supplier supplier) {
		return supplierService.save(supplier);
	}
}

