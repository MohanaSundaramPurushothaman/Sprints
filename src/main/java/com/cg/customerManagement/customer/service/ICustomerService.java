package com.cg.customerManagement.customer.service;

import com.cg.customerManagement.customer.entity.Customer;
import com.cg.customerManagement.items.entity.Item;

import javax.transaction.Transactional;
import java.util.Set;

public interface ICustomerService {

    public Customer findByID(long customerID);
    public Customer createCustomer(double v, String name);

    public Set<Item> itemsBoughtByCustomer(Long customerID);

    @Transactional
    Customer createCustomer(String name);

    Customer findById(Long customerId);

    public Customer addAmount(Long customerId, double amount);
}