package com.cg.customerManagement.customer.dao;

import com.cg.customerManagement.customer.entity.Customer;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CustomerDao implements ICustomerDao{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Customer add(Customer customer) {
        em.persist(customer);
        return customer;
    }

    @Transactional
    @Override
    public Customer findByID(long customerID) {
        return em.find(Customer.class,customerID);
    }

    @Transactional
    @Override
    public Customer update(Customer customer) {
        customer=em.merge(customer);
        return customer;
    }
}