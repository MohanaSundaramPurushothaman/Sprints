package com.cg.customerManagement.customer.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerManagement.customer.dto.AddAmountRequest;
import com.cg.customerManagement.customer.dto.CreateCustomerRequest;
import com.cg.customerManagement.customer.dto.CustomerDetail;
import com.cg.customerManagement.customer.service.ICustomerService;
import com.cg.customerManagement.customer.util.CustomerUtil;
import com.cg.customerManagement.items.dto.ItemDetail;
import com.cg.customerManagement.items.entity.Item;
import com.cg.customerManagement.items.util.ItemUtil;

@RequestMapping("/customers")
@RestController
public class ControllerClass {

    @Autowired
    private ICustomerService service;

    @Autowired
    private CustomerUtil util;

    @Autowired
    private ItemUtil iUtil;

    @PostMapping("/add")
    public CustomerDetail addNewCustomer(@RequestBody CreateCustomerRequest request)
    {
        return util.toDetail(service.createCustomer(request.getName()));
    }

    @GetMapping("/findbyid/{id}")
    public CustomerDetail findById(@PathVariable Long id)
    {
        return util.toDetail(service.findByID(id));
    }

    @PutMapping("/account/amount")
    public CustomerDetail addAmount(@RequestBody AddAmountRequest request)
    {
        return util.toDetail(service.addAmount(request.getId(), request.getAmount()));
    }

    @GetMapping("/customer/{id}")
    public Set<ItemDetail> itemBoughtByCustomer(@PathVariable Long id)
    {
        Set<Item>set=service.itemsBoughtByCustomer(id);
        return iUtil.toDetailSet(set);
    }


}