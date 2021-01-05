package com.cg.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.training.entity.Staff;

public class StaffDAOImpl implements StaffDAO{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("advertisement-management-system");

	
	public void addStaff(Staff staff) throws PersistenceException
	{
		EntityManager entityManager=emf.createEntityManager();
		try 
		{			
			entityManager.getTransaction().begin();
			entityManager.persist(staff);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}
		catch(PersistenceException e) 
		{
			entityManager.getTransaction().rollback();
			throw e;
		}
		catch(Exception e1)
		{
			throw e1;
		}
		finally 
		{
			entityManager.close();
		}	

		
	}

	public Staff getStaffById(Integer staffId) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try 
		{
			Staff staff =
					entityManager.find(Staff.class, staffId);			

			return staff;
		}
		catch(PersistenceException e) 
		{
			throw e;
		}
		catch(Exception e) 
		{
			throw e;
		}
		finally {
			entityManager.close();
		}	
		

	}

	public Integer deleteStaff(Integer staffId) throws PersistenceException
	{
		EntityManager entityManager=emf.createEntityManager();
		try 
		{
			entityManager.getTransaction().begin();
			Staff staff= 
					entityManager.find(Staff.class, staffId);
			entityManager.remove(staff);
			entityManager.getTransaction().commit();	
			return staff.getStaffId();
		}
		catch(PersistenceException e) 
		{
			entityManager.getTransaction().rollback();
			throw e;
		}
		catch(Exception e) 
		{
			throw e;
		}
		finally
		{
			entityManager.close();
		}	
	}


	public List<Staff> getAllStaff() throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		String jql= "From Staff s";
		try 
		{			
			entityManager.getTransaction().begin();

			TypedQuery<Staff> query=
					entityManager.createQuery(jql, Staff.class);
			List<Staff> staffList=query.getResultList();
			entityManager.getTransaction().commit();			
			return staffList;
		}
		catch(PersistenceException e) 
		{
			entityManager.getTransaction().rollback();			
			throw e;
		}
		catch(Exception e) 
		{
			throw e;
		}
		finally 
		{
			entityManager.close();
		}
		
	}


	public Staff updateStaff(Staff staff) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			Staff updatedStaff= entityManager.merge(staff);					
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updatedStaff;
		}
		catch(PersistenceException e) 
		{
			entityManager.getTransaction().rollback();
			throw e;
		}
		catch(Exception e) 
		{
			throw e;
		}
		finally 
		{
			entityManager.close();
		}	
	}
	

}