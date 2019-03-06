package com.thesundaylunatics.controller;

import com.thesundaylunatics.model.Product;
import com.thesundaylunatics.model.ProductInventory;
import com.thesundaylunatics.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest2")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(value="/productInventory", method = RequestMethod.GET)
	public List<ProductInventory> listProductInventory() {
		return inventoryService.list();
	}
	
	@RequestMapping(value = "/productInventory/{id}", method = RequestMethod.GET)
	public ProductInventory getProductInventory(@PathVariable(value = "id") Long id) {
		return inventoryService.get(id);
	}
	
	@RequestMapping(value = "/productInventory", method = RequestMethod.POST)
	public ProductInventory saveProductInventory(@RequestBody ProductInventory order) {
		return inventoryService.save(order);
	}
}

