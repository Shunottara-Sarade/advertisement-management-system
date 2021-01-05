package com.cg.training.service;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.training.dao.CustomerDAO;
import com.cg.training.dao.CustomerDaoImpl;
import com.cg.training.entity.CustomerMaster;
import com.cg.training.exception.CustomerException;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO customerDao= new CustomerDaoImpl();

	//validate Customer
	@Override
	public void addCustomer(CustomerMaster customer) throws CustomerException {
		try {
			customerDao.addCustomer(customer);			
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage(),e);
		}

	}

	//Get Customer By ID
	@Override
	public CustomerMaster getCustomerById(Integer cust_id) throws CustomerException {
		try {			
			CustomerMaster customer= customerDao.getCustomerById(cust_id);
			return customer;
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage(),e);
		}
	}
	
	//Delete Customer
	@Override
	public Integer deleteCustomer(Integer cust_id) throws CustomerException {
		try {			
			Integer id= customerDao.deleteCustomer(cust_id);
			return id;
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage(),e);
		}
	}
	
	//Get All Customer
	@Override
	public List<CustomerMaster> getAllCustomer() throws CustomerException {
		try {			
			List<CustomerMaster> customerList= 
					customerDao.getAllCustomer();
			return customerList;
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage(),e);
		}
	}
	
	//Update Customer
	@Override
	public CustomerMaster updateCustomer(CustomerMaster customer) throws CustomerException {
		try {			
			CustomerMaster updatedCustomer= 
					customerDao.updateCustomer(customer);
			return updatedCustomer;
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage(),e);
		}
	}


}