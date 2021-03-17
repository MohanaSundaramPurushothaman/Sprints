package com.cg.customerManagement.customer.entity;

import com.cg.customerManagement.items.entity.Item;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer extends Item {
    @GeneratedValue
    @Id
    private long id;
    private String name;

    @OneToOne
    Account account;

    @OneToMany
    Set<Item> boughtItems;

    public Customer() {}

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Item> getBoughtItems() { return boughtItems; }

    public void setBoughtItems(Set<Item> boughtItems) { this.boughtItems = boughtItems; }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", account=" + account + "]";
    }
}