package com.cg.customerManagement.customer.service;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.customerManagement.customer.entity.*;
import com.cg.customerManagement.customer.dao.*;
import com.cg.customerManagement.items.entity.Item;
import com.cg.customerManagement.customer.exception.CustomerNotFoundException;
import java.util.*;




    @Service 
    public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository cRepository;
    @Autowired
    private IAccountRepository aRepository;

    @Transactional
    @Override
    public Customer createCustomer(String name) {

        LocalDateTime currentTime = LocalDateTime.now();
        Account account = new Account(99999, currentTime);

        aRepository.save(account);
        Customer customer = new Customer(name, account);

        customer = cRepository.save(customer);
        return customer;

    }

    @Override
    public Customer findById(String customerId) {
        Optional<Customer> optional = cRepository.findById(customerId);
        if (!optional.isPresent()) {
            throw new CustomerNotFoundException("No Customer found for this id");
        }

        return optional.get();
    }

	@Transactional
    @Override
    public Customer addAmount(String customerId, double amount) {

        Customer customer = findById(customerId);
        Account account = customer.getAccount();
        account.setBalance(amount);
        aRepository.save(account);
        cRepository.save(customer);
        return customer;
    }

    @Override
    public Customer findByID(String customerID) {
        return null;
    }

    @Override
    public Customer createCustomer(double v, String name) {
        return null;
    }

    @Override
    public Set<Item> itemsBoughtByCustomer(Long customerID) {
        Optional<Customer> customer = cRepository.findById(customerID);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("No Customer found for this id");
        }
        Customer c = customer.get();
        return c.getBoughtItems();
    }

}