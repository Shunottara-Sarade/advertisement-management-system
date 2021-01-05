package com.cg.training.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.training.entity.CustomerMaster;

public interface CustomerDAO {

	
	public void addCustomer(CustomerMaster customer) throws PersistenceException;
	public CustomerMaster getCustomerById(Integer cust_id) throws PersistenceException;
	public Integer deleteCustomer(Integer cust_id) throws PersistenceException;
	public List<CustomerMaster> getAllCustomer() throws PersistenceException;
	public CustomerMaster updateCustomer(CustomerMaster customer) throws PersistenceException;

}
