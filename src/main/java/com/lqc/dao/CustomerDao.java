package com.lqc.dao;

import java.util.List;

import com.lqc.entity.Customer;

public interface CustomerDao {

	List<Customer> findAll();

	void save(Customer customer);

}
