package com.cg.customerManagement.items.service;


import com.cg.customerManagement.items.entity.Item;

public interface IItemService {
	
	 public Item create(double price, String description);
	 public Item findByID(String itemID);
	 public Item buyItem(String itemID, Long customerID);
}