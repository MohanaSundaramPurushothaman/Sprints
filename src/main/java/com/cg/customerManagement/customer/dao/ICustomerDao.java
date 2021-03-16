package com.cg.customerManagement.customer.dao;

import com.cg.customerManagement.customer.entity.Customer;

public interface ICustomerDao {
	
	public Customer add(Customer customer);
    public Customer findByID(long customerID);
    public Customer update(Customer customer);

}