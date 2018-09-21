package com.lqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lqc.entity.Customer;
import com.lqc.entity.User;
import com.lqc.service.CustomerService;
import com.lqc.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource(name = "customerServiceImpl")
	private CustomerService customerService;
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(ModelMap modelMap) {
		return "/customer/list";
	}
	
	@ResponseBody
	@RequestMapping("/load")
	public List<Customer> load(String name) {
//		List<Customer> customers = customerService.findAll();
		List<Customer> customers = customerService.findList(name);
		return customers;
	}
	
	@RequestMapping("/add")
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("operation", "add");
		List<User> users = userService.getUsers();
		modelMap.addAttribute("users", users);
		return "/customer/detail";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/list.jhtml";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap modelMap, String id) {
		modelMap.addAttribute("operation", "edit");
		Customer customer = customerService.findCustomerById(id);
		modelMap.addAttribute("customer", customer);
		List<User> users = userService.getUsers();
		modelMap.addAttribute("users", users);
		return "/customer/detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Customer customer) {
		customerService.update(customer);
		return "redirect:/customer/list.jhtml";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(String id) {
		customerService.removeCustomerById(id);
		return "redirect:/customer/list.jhtml";
	}
	
	@RequestMapping("/view")
	public String view(ModelMap modelMap, String id) {
		modelMap.addAttribute("operation", "view");
		Customer customer = customerService.findCustomerById(id);
		modelMap.addAttribute("customer", customer);
		List<User> users = userService.getUsers();
		modelMap.addAttribute("users", users);
		return "/customer/detail";
	}

}
