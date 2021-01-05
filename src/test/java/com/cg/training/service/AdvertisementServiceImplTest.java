package com.cg.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.training.dao.AdvertisementDaoImpl;
import com.cg.training.entity.AdvertisementDetails;
import com.cg.training.entity.CustomerMaster;
import com.cg.training.entity.Role;
import com.cg.training.entity.Staff;
import com.cg.training.exception.AdvertisementException;
import com.cg.training.exception.CustomerException;

@RunWith(MockitoJUnitRunner.class)
class AdvertisementServiceImplTest {
	 @Mock
	 private AdvertisementDaoImpl advertisementDAO;
	 
     @InjectMocks
	 private AdvertisementServiceImpl advertisementService;
     @BeforeEach
     public void setup(){
         MockitoAnnotations.initMocks(this); //without this you will get NPE
     }

	@Test
	void testAddAdvertisement() {
		
		AdvertisementDetails advertisement=new AdvertisementDetails();
        advertisement.setId(1);
        advertisement.setAdvType("commercial");
        advertisement.setCreatedBy("Own");
        advertisement.setAdvLocation("Pune");
        advertisement.setStartDate(LocalDate.of(2020, 11, 11));
        advertisement.setEndDate(LocalDate.of(2021, 11, 11));
        advertisement.setCustomer(new CustomerMaster(1, "Rohit", "Sharma", "rohit@gmail.com", "9876543212", "rohit@123"));
        advertisement.setStaff(new Staff(1, "Ravi", "Shashtri", "ravi@gmail.com", "9876543212", Role.ADMIN, "ravi@123"));

 

        try {
            advertisementService.addAdvertisement(advertisement);
            verify(advertisementDAO,times(1)).addAdvertisement(advertisement);
        } catch (AdvertisementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@Test
	void testDeleteAdvertisement() {
	    AdvertisementDetails advertisement=new AdvertisementDetails();
        advertisement.setId(1);
        advertisement.setAdvType("commercial");
        advertisement.setCreatedBy("Own");
        advertisement.setAdvLocation("Pune");
        advertisement.setStartDate(LocalDate.of(2020, 11, 11));
        advertisement.setEndDate(LocalDate.of(2021, 11, 11));
        advertisement.setCustomer(new CustomerMaster(1, "Rohit", "Sharma", "rohit@gmail.com", "9876543212", "rohit@123"));
        advertisement.setStaff(new Staff(1, "Ravi", "Shashtri", "ravi@gmail.com", "9876543212", Role.ADMIN, "ravi@123"));

        try {
            advertisementService.deleteAdvertisement(1);
            verify(advertisementDAO,times(1)).deleteAdvertisement(1);
        } catch (AdvertisementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

 
	}

	@Test
	void testGetAllAdvertisement() {
		  AdvertisementDetails advertisement= new AdvertisementDetails();
	        List<AdvertisementDetails> advertisementList = new ArrayList<AdvertisementDetails>();
	        advertisement.setId(1);
	        advertisement.setAdvType("commercial");
	        advertisement.setCreatedBy("Own");
	        advertisement.setAdvLocation("Pune");
	        advertisement.setStartDate(LocalDate.of(2020, 11, 11));
	        advertisement.setEndDate(LocalDate.of(2021, 11, 11));
	        advertisement.setCustomer(new CustomerMaster(1,"Rohit", "Sharma", "rohit@gmail.com", "9876543212", "rohit@123"));
	        advertisement.setStaff(new Staff(1, "Ravi", "Shashtri", "ravi@gmail.com", "9876543212", Role.ADMIN, "ravi@123"));

	        advertisementList.add(advertisement);
	        Mockito.when(advertisementDAO.
	                getAllAdvertisement()).thenReturn(advertisementList);
	        
	        assertEquals(advertisementList, advertisementDAO.getAllAdvertisement());
	}

	@Test
	void testUpdateAdvertisement() {
		AdvertisementDetails advertisement= new AdvertisementDetails();
        advertisement.setId(1);
         advertisement.setAdvType("Commercial");
         advertisement.setCreatedBy("Own");
         advertisement.setAdvLocation("Pune");
         advertisement.setStartDate(LocalDate.of(2020, 11, 11));
         advertisement.setEndDate(LocalDate.of(2021, 11, 11));
         advertisement.setCustomer(new CustomerMaster(1,"Rohit", "Sharma", "rohit@gmail.com", "9876543212", "rohit@123"));
         advertisement.setStaff(new Staff(1, "Ravi", "Shashtri", "ravi@gmail.com", "9876543212", Role.ADMIN, "ravi@123"));
       advertisement.setEndDate(LocalDate.of(2021, 05, 21));
         try {
            advertisementService.updateAdvertisement(advertisement);
            assertEquals(LocalDate.of(2021, 05, 21), advertisement.getEndDate());
        } catch (AdvertisementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	}

