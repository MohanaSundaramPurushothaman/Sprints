package com.cg.customerManagement.items.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customerManagement.items.entity.Item;

public interface IItemRepository extends JpaRepository<Item,String> {

}