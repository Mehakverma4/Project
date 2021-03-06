package com.specs.specsfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.specs.specsbackend.dao.CustomerRepository;
import com.specs.specsbackend.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="addCustomer", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") Customer customer){
		customerRepository.addCustomer(customer);
		
		return "login";
		
	}
	
	
}
