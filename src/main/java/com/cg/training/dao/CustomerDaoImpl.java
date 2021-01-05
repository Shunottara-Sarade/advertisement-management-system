package com.cg.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.training.entity.CustomerMaster;

public class CustomerDaoImpl implements CustomerDAO{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("advertisement-management-system");


	public void addCustomer(CustomerMaster customer) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {	
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}	


	}

	public CustomerMaster getCustomerById(Integer cust_id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			CustomerMaster customer =
					entityManager.find(CustomerMaster.class,cust_id);			
			return customer;
		}catch(PersistenceException e) {
			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}	

	}


	public Integer deleteCustomer(Integer cust_id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			CustomerMaster customer=
					entityManager.find(CustomerMaster.class, cust_id);
			entityManager.remove(customer);
			//			entityManager.flush();
			entityManager.getTransaction().commit();	
			return customer.getCustId();
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}	
	}

	public List<CustomerMaster> getAllCustomer() throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		String jql= "From CustomerMaster c";
		try {			
			entityManager.getTransaction().begin();
			TypedQuery<CustomerMaster> query=
					entityManager.createQuery(jql, CustomerMaster.class);
			List<CustomerMaster> customerList=query.getResultList();
			entityManager.getTransaction().commit();			
			return customerList;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();		

			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}
	}

	public CustomerMaster updateCustomer(CustomerMaster customer) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			CustomerMaster updatedCustomer= 
					entityManager.merge(customer);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updatedCustomer;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}	
	}



}
