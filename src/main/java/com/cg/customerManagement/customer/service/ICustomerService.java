package com.cg.customerManagement.customer.service;

import com.cg.customerManagement.customer.entity.Customer;
import com.cg.customerManagement.items.entity.Item;

import javax.transaction.Transactional;
import java.util.Set;

public interface ICustomerService {

    public Customer findByID(String string);
    public Customer createCustomer(double v, String name);

    public Set<Item> itemsBoughtByCustomer(Long customerID);

    @Transactional
    Customer createCustomer(String name);

	public Customer addAmount(String id, double amount);
	Customer findById(String customerId);
}