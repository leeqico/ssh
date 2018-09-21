package com.lqc.dao;

import java.util.List;

import com.lqc.entity.Customer;

public interface CustomerDao {

	List<Customer> findAll();

	void save(Customer customer);

	Customer findCustomerById(String id);

	void update(Customer customer);

	void removeCustomerById(String id);

	List<Customer> findList(String name);

}
