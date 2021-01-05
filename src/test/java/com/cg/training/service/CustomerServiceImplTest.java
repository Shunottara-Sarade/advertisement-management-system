package com.cg.training.service;

import static org.junit.jupiter.api.Assertions.*;

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
import com.cg.training.entity.CustomerMaster;
import com.cg.training.exception.CustomerException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
@RunWith(MockitoJUnitRunner.class)

class CustomerServiceImplTest {
    @Mock
    private CustomerDaoImpl customerDaoImpl;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }
    
    @Test
    public void testAddCustomer(){
        CustomerMaster customerMaster= new CustomerMaster();
        customerMaster.setCustId(1);
        customerMaster.setCustFirstName("Rohit");
        customerMaster.setCustLastName("Sharma");
        customerMaster.setCustEmail("rohit99@gmail.com");
        customerMaster.setCustMobile("1234567890");
        customerMaster.setCustPassword("rohit@123");
        try {
            customerServiceImpl.addCustomer(customerMaster);
            verify(customerDaoImpl,times(1)).addCustomer(customerMaster);
        } catch (CustomerException e) {
            e.printStackTrace();
        }

    }

    
    @Test
    public void updateCustomerTest() 
    {
        CustomerMaster customerMaster= new CustomerMaster();
        customerMaster.setCustId(1);
        customerMaster.setCustFirstName("Rohit");
        customerMaster.setCustLastName("Sharma");
        customerMaster.setCustEmail("rohit99@gmail.com");
        customerMaster.setCustMobile("1234567890");
        customerMaster.setCustPassword("rohit@123");
        customerMaster.setCustFirstName("RK");
        try {
            customerServiceImpl.updateCustomer(customerMaster);
            assertEquals("RK", customerMaster.getCustFirstName());
        } catch (CustomerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

 
    @Test
    void testDeleteCustomer() {
        //fail("Not yet implemented");
        CustomerMaster customerMaster= new CustomerMaster();
        customerMaster.setCustId(1);
        customerMaster.setCustFirstName("Rohit");
        customerMaster.setCustLastName("Sharma");
        customerMaster.setCustEmail("rohit99@gmail.com");
        customerMaster.setCustMobile("1234567890");
        customerMaster.setCustPassword("rohit@123");

        try {
            customerServiceImpl.deleteCustomer(1);
            verify(customerDaoImpl,times(1)).deleteCustomer(1);
        } catch (CustomerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    void testGetAllCustomer() {
        CustomerMaster customerMaster= new CustomerMaster();
        List<CustomerMaster> customerList = new ArrayList<CustomerMaster>();
        customerMaster.setCustId(1);
        customerMaster.setCustFirstName("Rohit");
        customerMaster.setCustLastName("Sharma");
        customerMaster.setCustEmail("rohit99@gmail.com");
        customerMaster.setCustMobile("1234567890");
        customerMaster.setCustPassword("rohit@123");
        customerList.add(customerMaster);
        Mockito.when(customerDaoImpl.
                getAllCustomer()).thenReturn(customerList);
        
        try {
            assertEquals(customerList, customerServiceImpl.getAllCustomer());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
    }

 

 

}
