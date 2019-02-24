package com.thesundaylunatics.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thesundaylunatics.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

}
