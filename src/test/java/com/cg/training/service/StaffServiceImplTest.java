package com.cg.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.training.dao.CustomerDaoImpl;
import com.cg.training.dao.StaffDAO;
import com.cg.training.dao.StaffDAOImpl;
import com.cg.training.entity.CustomerMaster;
import com.cg.training.entity.Role;
import com.cg.training.entity.Staff;
import com.cg.training.exception.CustomerException;
import com.cg.training.exception.StaffException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
@RunWith(MockitoJUnitRunner.class)
class StaffServiceImplTest {
	@Mock
	private StaffDAOImpl staffDaoImpl;
	
	@InjectMocks
	private StaffServiceImpl staffService;
	
	 @BeforeEach
	    public void setup(){
	        MockitoAnnotations.initMocks(this); //without this you will get NPE
	    }

	@Test
	void testAddStaff() {
		Staff staff=new Staff();
		staff.setStaffId(10);
		staff.setFirstName("Ravi");
		staff.setLastName("Shastri");
		staff.setEmail("ravi@gg.com");
		staff.setMobileNo("9874568974");
		staff.setRole(Role.ADMIN);
		staff.setPassword("ravi@123");
		
		try {
			staffService.addStaff(staff);
			verify(staffDaoImpl,times(1)).addStaff(staff);
		} catch (StaffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Test
	void testDeleteStaff() {
		Staff staff= new Staff();
		staff.setStaffId(10);
		staff.setFirstName("Ravi");
		staff.setLastName("Shastri");
		staff.setEmail("ravi@gg.com");
		staff.setMobileNo("9874568974");
		staff.setRole(Role.ADMIN);
		staff.setPassword("ravi@123");
        
        
            try {
				staffService.deleteStaff(1);
				verify(staffDaoImpl,times(1)).deleteStaff(1);
			} catch (StaffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        
	}

	@Test
	void testGetAllStaff() {
		Staff staff=new Staff();
		List<Staff> staffList = new ArrayList<Staff>();
		staff.setStaffId(10);
		staff.setFirstName("Ravi");
		staff.setLastName("Shastri");
		staff.setEmail("ravi@gg.com");
		staff.setMobileNo("9874568974");
		staff.setRole(Role.ADMIN);
		staff.setPassword("ravi@123");
		
		staffList.add(staff);
		Mockito.when(staffDaoImpl.getAllStaff()).thenReturn(staffList);
		try {
			assertEquals(staffList, staffService.getAllStaff());
		} catch (StaffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	void testUpdateStaff() {
		Staff staff=new Staff();
		staff.setStaffId(1);
		staff.setFirstName("Ravi");
		staff.setLastName("Shashtri");
		staff.setEmail("ravi@gg.com");
		staff.setMobileNo("9874568974");
		staff.setRole(Role.ADMIN);
		staff.setPassword("ravi@123");
		staff.setFirstName("Anil");
		try {
			staffService.updateStaff(staff);
			assertEquals("Anil",staff.getFirstName());
		} catch (StaffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
