  
package com.cg.customerManagement.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customerManagement.customer.entity.Customer;
import com.cg.customerManagement.customer.service.ICustomerService;



@Component
public class CustomerMain {
	
	@Autowired
	private ICustomerService service;

	
	
	public void start() {
		
		Customer c1=service.createCustomer("Mohana Sundaram .P");
		System.out.println(c1);
		Customer c2=service.createCustomer("Mohan");
		System.out.println(c2);
		
		Customer findC1=service.findByID(2);
		System.out.println("Customer found with id "+ findC1.getId()+ "And name= "+findC1.getName());
		Customer findC2=service.findByID(4);
		System.out.println("Customer found with id "+ findC2.getId()+ "And name= "+findC2.getName());
		
		
		
	}

}
