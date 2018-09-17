package com.lqc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqc.dao.CustomerDao;
import com.lqc.entity.Customer;
import com.lqc.service.CustomerService;

@Service(value = "customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
	
	@Resource(name = "customerDaoImpl")
	private CustomerDao customerDao;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		List<Customer> customers = customerDao.findAll();
		return customers;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
	}

}
