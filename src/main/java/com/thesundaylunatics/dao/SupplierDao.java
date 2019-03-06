package com.thesundaylunatics.dao;

import com.thesundaylunatics.model.ProductInventory;
import com.thesundaylunatics.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends CrudRepository<Supplier, Long> {

}
