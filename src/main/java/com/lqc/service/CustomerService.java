package com.lqc.service;

import java.util.List;

import com.lqc.common.query.Page;
import com.lqc.common.query.Pageable;
import com.lqc.common.query.PropertyFilter;
import com.lqc.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void save(Customer customer);

	Customer findCustomerById(String id);

	void update(Customer customer);

	void removeCustomerById(String id);

	List<Customer> findList(String name);

	Page<Customer> findPage(PropertyFilter[] propertyFilters, Pageable pageable);
	
}
