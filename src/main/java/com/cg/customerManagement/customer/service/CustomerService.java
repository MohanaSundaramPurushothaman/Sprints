package com.cg.customerManagement.customer.service;


import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customerManagement.customer.entity.*;
import com.cg.customerManagement.customer.dao.*;



@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDao dao;
	
	@Autowired
	private EntityManager em;

	@Override
	public Customer findByID(long customerID) {
		Customer customer=dao.findByID(customerID);
		return customer;
	}

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime currentTime=LocalDateTime.now();
		Account account=new Account(-1,currentTime);
		em.persist(account);
		Customer customer=new Customer(name,account);
		return dao.add(customer);
	}
	

}