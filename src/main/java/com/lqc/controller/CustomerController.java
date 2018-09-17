package com.lqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lqc.entity.Customer;
import com.lqc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource(name = "customerServiceImpl")
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String list() {
		return "/customer/list";
	}
	
	@ResponseBody
	@RequestMapping("/load")
	public List<Customer> load() {
		List<Customer> customers = customerService.findAll();
		return customers;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "/customer/detail";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/list.jhtml";
	}

}
