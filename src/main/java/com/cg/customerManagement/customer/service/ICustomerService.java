package com.cg.customerManagement.customer.service;

import com.cg.customerManagement.customer.entity.Customer;

public interface ICustomerService {
	
	public Customer findByID(long customerID);
    public Customer createCustomer(String name);

}