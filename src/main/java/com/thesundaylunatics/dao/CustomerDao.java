package com.thesundaylunatics.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thesundaylunatics.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

}
