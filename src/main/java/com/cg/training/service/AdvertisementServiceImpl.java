package com.cg.training.service;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.training.dao.AdvertisementDAO;
import com.cg.training.dao.AdvertisementDaoImpl;
import com.cg.training.entity.AdvertisementDetails;
import com.cg.training.exception.AdvertisementException;

public class AdvertisementServiceImpl implements AdvertisementService{
	private AdvertisementDAO advertisementDao= new AdvertisementDaoImpl();

	@Override
	public void addAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException {
		try {
			//validate product
			advertisementDao.addAdvertisement(advertisement);			
		}catch(PersistenceException e) {
			throw new AdvertisementException(e.getMessage(),e);
		}

	}

	@Override
	public AdvertisementDetails getAdvertisementById(Integer id) throws AdvertisementException {
		try {			
			AdvertisementDetails advertisement= advertisementDao.getAdvertisementById(id);
			return advertisement;
		}catch(PersistenceException e) {
			throw new AdvertisementException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteAdvertisement(Integer id) throws AdvertisementException {
		try {			
			Integer id1= advertisementDao.deleteAdvertisement(id);
			return id1;
		}catch(PersistenceException e) {
			throw new AdvertisementException(e.getMessage(),e);
		}
	}

	@Override
	public List<AdvertisementDetails> getAllAdvertisement() throws AdvertisementException {
		try {			
			List<AdvertisementDetails> advertisementList= 
					advertisementDao.getAllAdvertisement();
			return advertisementList;
		}catch(PersistenceException e) {
			throw new AdvertisementException(e.getMessage(),e);
		}
	}

	@Override
	public AdvertisementDetails updateAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException {
		try {			
			AdvertisementDetails updatedAdvertisement= 
					advertisementDao.updateAdvertisement(advertisement);
			return updatedAdvertisement;
		}catch(PersistenceException e) {
			throw new AdvertisementException(e.getMessage(),e);
		}
	}

}
