package com.cg.customerManagement.customer.ui;

import com.cg.customerManagement.customer.entity.Customer;
import com.cg.customerManagement.customer.service.ICustomerService;
import com.cg.customerManagement.items.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMain {

    @Autowired
    private ICustomerService service;

    public static void main(String[] args) {
        CustomerMain project=new CustomerMain();
        project.start();
    }

    public void start() {
        System.out.println("Customer Creation..........");
        System.out.println();
        Customer customer1 = service.createCustomer(12000.0, "Mohana Sundaram P");
        Customer customer2 = service.createCustomer(12000.0, "M S P");
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println();
        System.out.println("Item Creation..........");
        System.out.println();

        Item item1 = service.createCustomer(60000.00, "iphone-se");
        System.out.println("id=" + item1.getId() + " ,description=" + item1.getDescription() + " and price= " + item1.getPrice());

        Customer item2 = service.createCustomer(16000.0, "realme 2 pro");
        System.out.println("id=" + item2.getId() + " ,description=" + item2.getDescription() + " and price= " + item2.getPrice());

        Customer findItem1 = service.findByID(item2.getId());
        System.out.println("id=" + findItem1.getId() + " and description=" + findItem1.getDescription());

    }
}