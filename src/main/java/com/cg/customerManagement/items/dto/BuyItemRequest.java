package com.cg.customerManagement.items.dto;


public class BuyItemRequest {
    private String item_id;
    private Long customer_id;


    public String getItem_id() {
        return item_id;
    }
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
    public Long getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }



}