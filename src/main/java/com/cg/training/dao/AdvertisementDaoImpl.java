package com.cg.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.training.entity.AdvertisementDetails;

public class AdvertisementDaoImpl implements AdvertisementDAO{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("advertisement-management-system");

	//adding Advertisement
	public void addAdvertisement(AdvertisementDetails advertisement) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.merge(advertisement);
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
	
	//Get Advertisement By Id
	public AdvertisementDetails getAdvertisementById(Integer id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			AdvertisementDetails advertisement =
					entityManager.find(AdvertisementDetails.class, id);			
			return advertisement;
		}catch(PersistenceException e) {
			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}	

	}

	//Delete Advertisement
	public Integer deleteAdvertisement(Integer id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			AdvertisementDetails  advertisement= 
					entityManager.find(AdvertisementDetails.class, id);
			entityManager.remove(advertisement);
			entityManager.getTransaction().commit();	
			return advertisement.getId();
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}	
	}

	//Get All Advertisement
	public List<AdvertisementDetails> getAllAdvertisement() throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		String jql= "From AdvertisementDetails a";
		try {			
			entityManager.getTransaction().begin();
			TypedQuery<AdvertisementDetails> query=
					entityManager.createQuery(jql, AdvertisementDetails.class);
			List<AdvertisementDetails> advertisementList=query.getResultList();
			entityManager.getTransaction().commit();			
			return advertisementList;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();		

			throw e;
		}catch(Exception e) {
			throw new PersistenceException(e.getMessage());
		}finally {
			entityManager.close();
		}
	}

	//Update Advertisement
	public AdvertisementDetails updateAdvertisement(AdvertisementDetails advertisement) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			AdvertisementDetails updatedAdvertisementDetails= 
					entityManager.merge(advertisement);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updatedAdvertisementDetails;
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