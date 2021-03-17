package com.cg.customerManagement.customer.util;

import org.springframework.stereotype.Component;
import com.cg.customerManagement.customer.dto.CustomerDetail;
import com.cg.customerManagement.customer.entity.Customer;

@Component
public class CustomerUtil {

    public CustomerDetail toDetail(Customer customer) {
        CustomerDetail cdetail=new CustomerDetail();
        cdetail.setId(customer.getId());
        cdetail.setName(customer.getName());
        cdetail.setAccount_id(customer.getAccount().getAccountId());
        cdetail.setBalance(customer.getAccount().getBalance());
        return cdetail;
    }
}