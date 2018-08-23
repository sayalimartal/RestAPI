package com.demo.rest.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

@XmlRootElement
@Entity
public class Customer extends ResourceSupport{
	
	@Id
	private final int customerId;
	private String customerName;
	private long contactNumber;
	private String emailId;
	private String dateOfBirth;
	private String url;
	
	private static int custId;
	
	static {
		custId = 200;
	}
	
	{
		this.customerId = ++custId;
	}
	
	public Customer() {
		
	}

	public Customer(String customerName, long contactNumber, String emailId, String dateOfBirth,String url) {
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.url = url;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", url=" + url + "]";
	}



}

