package com.thesundaylunatics.dao;

import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.model.ProductInventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryDao extends CrudRepository<ProductInventory, Long> {

}
