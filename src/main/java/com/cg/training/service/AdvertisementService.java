package com.cg.training.service;

import java.util.List;

import com.cg.training.entity.AdvertisementDetails;
import com.cg.training.exception.AdvertisementException;

public interface AdvertisementService {
	public void addAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException;
	public AdvertisementDetails getAdvertisementById(Integer id) throws AdvertisementException;
	public Integer deleteAdvertisement(Integer id) throws AdvertisementException;
	public List<AdvertisementDetails> getAllAdvertisement() throws AdvertisementException;
	public AdvertisementDetails updateAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException;
}
