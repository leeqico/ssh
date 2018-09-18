package com.lqc.service;

import java.util.List;

import com.lqc.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void save(Customer customer);

	Customer findCustomerById(String id);

	void update(Customer customer);

	void removeCustomerById(String id);
	
}
