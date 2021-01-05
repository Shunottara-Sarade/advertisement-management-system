package com.cg.training.service;

import java.util.List;

import com.cg.training.entity.CustomerMaster;
import com.cg.training.exception.CustomerException;

public interface CustomerService {
	public void addCustomer(CustomerMaster customer) throws CustomerException;
	public CustomerMaster getCustomerById(Integer cust_id) throws CustomerException;
	public Integer deleteCustomer(Integer cust_id) throws CustomerException;
	public List<CustomerMaster> getAllCustomer() throws CustomerException;
	public CustomerMaster updateCustomer(CustomerMaster customer) throws CustomerException;
}