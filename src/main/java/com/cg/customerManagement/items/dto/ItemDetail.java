package com.cg.customerManagement.items.dto;
public class ItemDetail {

    private long id;
    private double price;
    private String description;
    private Long c_id;
    private String c_name;


    public ItemDetail(long id, double price, String description, long id1, String name) {
    }


    public ItemDetail(String id2, double price2, String description2, long id3, String name) {
	}


	public ItemDetail(String id2, double price2, String description2, String id3, String name) {
	}


	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getC_id() {
        return c_id;
    }
    public void setC_id(long c_id) {
        this.c_id = c_id;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}