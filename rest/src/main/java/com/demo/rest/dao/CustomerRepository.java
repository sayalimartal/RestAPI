package com.demo.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.rest.pojo.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

}
