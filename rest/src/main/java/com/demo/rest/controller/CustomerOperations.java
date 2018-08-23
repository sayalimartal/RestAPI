package com.demo.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.pojo.Customer;
import com.demo.rest.service.CustomerServiceImpl;

@RestController
public class CustomerOperations {
	
	@Autowired
	CustomerServiceImpl service;
	
	@RequestMapping(value="/customer/add", method=RequestMethod.POST)
	public Customer addCustomer(String customerName, long contactNumber, String emailId, String dateOfBirth,String url) {
		Customer customer = new Customer(customerName, contactNumber, emailId, dateOfBirth,url);
		return service.addCustomer(customer);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/customers/{start}/{count}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public Resources viewAllCustomersInPages(@PathVariable("start") int start, @PathVariable("count") int count) {
		List<Customer> tempCustomers =  service.viewAllCustomers();
		List<Customer> customers = new ArrayList<>();
		for(int i=start;i<start+count;i++)
		{
			customers.add(tempCustomers.get(i));		
		}
		Link nextLink = linkTo(methodOn(this.getClass()).viewAllCustomersInPages(start+count>(tempCustomers.size()-count)?tempCustomers.size()-count+1:start+count,count)).withRel("nextLink");
		Link previousLink = linkTo(methodOn(this.getClass()).viewAllCustomersInPages(start-count>=0?start-count:1,count)).withRel("previousLink");
		
		return new  Resources<>(customers,previousLink,nextLink);
	}
	
	@RequestMapping(value="/customer/view/{customerId}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public Customer viewCustomer(@PathVariable int customerId) {
//		Customer customer = service.viewCustomer(customerId);
		
		
		
		//customer.add(linkTo(methodOn((CustomerOperations.class).updateCustomer(customer).withSelfRel())));
		return service.viewCustomer(customerId);
	}
	
	@RequestMapping(value="/customer/delete", method=RequestMethod.DELETE, consumes="application/json")
	public void deleteCustomer(@RequestBody Customer customer) {
		service.deleteCustomer(customer);
	}
	
	@RequestMapping(value="/customer/update", method=RequestMethod.PUT, consumes="application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {	
		return service.updateCustomer(customer);
	}
}
