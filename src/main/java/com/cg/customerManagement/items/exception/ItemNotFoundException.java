package com.cg.customerManagement.items.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String msg)
    {
        super(msg);
    }

}