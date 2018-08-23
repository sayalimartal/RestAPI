package com.demo.rest.service;

import java.util.Collection;

import com.demo.rest.pojo.Customer;


public interface CustomerService {
	Customer addCustomer(Customer customer);
	Collection<Customer> viewAllCustomers();
	void deleteCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer viewCustomer(int customerId);
}
