package com.cg.customerManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.cg.customerManagement.customer.ui.CustomerMain;

@SpringBootApplication
public class CustomerManagementApplication {
  public static void main(String[] args) {
      SpringApplication.run(CustomerManagementApplication.class, args);
  }
}