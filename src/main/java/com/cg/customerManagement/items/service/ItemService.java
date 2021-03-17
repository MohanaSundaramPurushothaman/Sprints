package com.cg.customerManagement.items.service;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customerManagement.customer.dao.ICustomerRepository;
import com.cg.customerManagement.customer.entity.Customer;
import com.cg.customerManagement.customer.exception.CustomerNotFoundException;
import com.cg.customerManagement.items.dao.IItemRepository;
import com.cg.customerManagement.items.entity.Item;
import com.cg.customerManagement.items.exception.ItemNotFoundException;


@Service
public class ItemService implements IItemService{
	
	@Autowired
	private IItemRepository iRepository;
	@Autowired
	private ICustomerRepository cRespository;
	
	 public String generateId(int length){
	        StringBuilder builder = new StringBuilder();
	        for (int i=0;i<length;i++){
	            Random random = new Random();
	            int randomNum=random.nextInt(10);
	            builder.append(randomNum);
	        }
	        return builder.toString();
	    }
	
	
	

	@Override
	public Item create(double price, String description) {
		Item item=new Item(price,description);
		LocalDateTime currentTime=LocalDateTime.now();
		item.setAddedDate(currentTime);
		String id=generateId(10);
		item.setId(id);
		item=iRepository.save(item);
		return item;
	}

	@Override
	public Item findByID(String itemID) {
		Optional<Item>optional= iRepository.findById(itemID);
		if(!optional.isPresent())
		{
			throw new ItemNotFoundException("Item with this ID is not present , Enter Correct Id");
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Item buyItem(String itemID, Long customerID) {
		Optional<Customer>oc=cRespository.findById(customerID);
		if(!oc.isPresent())
		{
			throw new CustomerNotFoundException("-------- Customer With this ID is not present -------- ");
		}
		Customer c=oc.get();
		Optional<Item>oi= iRepository.findById(itemID);
		if(!oi.isPresent())
		{
			throw new ItemNotFoundException("Item with this ID is not present , Enter Correct Id");
		}
		Item item=oi.get();
		item.setBoughtBy(c);
		item=iRepository.save(item);
		Set<Item>set=c.getBoughtItems();
		if(set==null)
		{
			set=new HashSet<>();
			c.setBoughtItems(set);
		}
		set.add(item);
		cRespository.save(c);
		return item;
	}	

}