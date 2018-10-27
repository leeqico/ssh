package com.lqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lqc.common.controller.BaseController;
import com.lqc.common.query.Page;
import com.lqc.common.query.Pageable;
import com.lqc.common.query.PropertyFilter;
import com.lqc.entity.Customer;
import com.lqc.entity.User;
import com.lqc.service.CustomerService;
import com.lqc.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{
	
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
	public Page<Customer> load(String filterRules, Pageable pageable) {
		PropertyFilter[] propertyFilters = parsePropertyFilters(filterRules);
		Page<Customer> customers = customerService.findPage(propertyFilters,pageable);
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
	public String save(Customer customer, String userId) {
		if (StringUtils.isNotEmpty(userId)) {
			customer.setUser(userService.findById(userId));
		}
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
	public String update(Customer customer, String userId) {
		if (StringUtils.isNotEmpty(userId)) {
			customer.setUser(userService.findById(userId));
		}
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
	
	@RequestMapping("/print")
	public String print(ModelMap modelMap, String id) {
		Customer customer = customerService.findCustomerById(id);
		modelMap.addAttribute("customer", customer);
		return "/customer/print";
	}

}
