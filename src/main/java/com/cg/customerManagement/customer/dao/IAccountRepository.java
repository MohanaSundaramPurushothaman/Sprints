package com.cg.customerManagement.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.customerManagement.customer.entity.Account;

public interface IAccountRepository extends JpaRepository<Account,Long> {
}