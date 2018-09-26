package com.lqc.dao;

import java.util.List;

import com.lqc.common.dao.BaseDao;
import com.lqc.common.query.Page;
import com.lqc.common.query.Pageable;
import com.lqc.entity.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	List<Customer> findAll();

	void save(Customer customer);

	Customer findCustomerById(String id);

	void update(Customer customer);

	void removeCustomerById(String id);

	List<Customer> findList(String name);

	Page<Customer> findPage(Pageable pageable, String name);

}
