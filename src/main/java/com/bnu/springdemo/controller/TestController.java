package com.bnu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bnu.springdemo.entity.Customer;
import com.bnu.springdemo.entity.SalesOrder;
import com.bnu.springdemo.service.CustomerService;

@Controller
public class TestController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/orderDetails")
	public String getOrdersWithDetails() {
		
		try {
			List<SalesOrder> ordersList = customerService.getOrdersWithDetails();
		
			for (SalesOrder salesOrder : ordersList) {
				Customer customer = salesOrder.getCustomer();
				System.out.println("Customer Name: "+customer.getName());
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return "";
	}
}
