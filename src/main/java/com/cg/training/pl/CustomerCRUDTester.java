package com.cg.training.pl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.training.entity.CustomerMaster;
import com.cg.training.exception.CustomerException;
import com.cg.training.service.CustomerService;
import com.cg.training.service.CustomerServiceImpl;

public class CustomerCRUDTester {
	private static Scanner scanner=new Scanner(System.in);
	private static CustomerService service= new CustomerServiceImpl();
	private static Logger plLogger= Logger.getLogger(CustomerCRUDTester.class);
	public static void main(String[] args) {
		while(true) {
			System.out.println("1. Add customer\n2. List customer by Id \n3. Delete customer \n4. List all customer\n5. Update customer");
			int option= Integer.parseInt(scanner.nextLine());
			try {
				switch(option) {
				
				case 1: CustomerMaster customer=new CustomerMaster();
				addCustomer(customer);
				plLogger.info("1 customer added");
				break;
				
				case 2: System.out.println("Enter customer Id");
				Integer cust_id = scanner.nextInt();
				customer= getCustomerById(cust_id);                        
				System.out.println(customer);
				plLogger.info("1 customer fetched");
				break;
				
				case 3: System.out.println("Enter customer id: ");
				cust_id= scanner.nextInt();
				Integer id= deleteCustomer(cust_id);
				plLogger.info("Customer: "+id+" deleted");
				break;
				
				case 4: List<CustomerMaster> customerList= getAllCustomer();
				customerList.stream().forEach(System.out::println);
				plLogger.info("Fetching all customers");
				break;
				
				case 5: System.out.println("Enter customer id to be updated: ");
				cust_id= scanner.nextInt();
				customer= getCustomerById(cust_id);    
				CustomerMaster updatedCustomer= updateCustomer(customer);
				System.out.println(updatedCustomer);
				plLogger.info(cust_id+" updated");
				break;
				
				default: System.out.println("Invalid option");
				break;                
				}
			}catch(CustomerException e) {
				e.printStackTrace();
			}
			System.out.println("Enter y to continue..");
			String ch=scanner.nextLine();
			if(!ch.equalsIgnoreCase("y")) {
				break;
			}

		}
	}

	private static void addCustomer(CustomerMaster customer) throws CustomerException {

		System.out.println("First letter should be capital and only characters are allowed");
		System.out.println("Enter customer first name:");
		customer.setCustFirstName(scanner.nextLine());
		while(!(customer.getCustFirstName().matches("[A-Z][a-z]*")))
		{
			System.out.println("Enter valid name");  
			System.out.println("Enter customer first name:");
			customer.setCustFirstName(scanner.nextLine());
		}

		//System.out.println("First letter should be capital and only characters are allowed");
		System.out.println("Enter customer last name:");
		customer.setCustLastName(scanner.nextLine());
		while(!(customer.getCustLastName().matches( "[A-Z][a-z]*")))
		{
			System.out.println("Enter valid name");
			System.out.println("Enter customer last name:");
			customer.setCustLastName(scanner.nextLine());
		}

		System.out.println("Enter email:");
		customer.setCustEmail(scanner.nextLine());

		while(!(customer.getCustEmail().matches("[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+")))
		{
			System.out.println("Invalid email address");
			System.out.println("Enter email:");
			customer.setCustEmail(scanner.nextLine());
		}

		System.out.println("Enter mobile number");
		customer.setCustMobile(scanner.nextLine());
		while(!(customer.getCustMobile().matches("(0/91)?[7-9][0-9]{9}")))
		{
			System.out.println("Invalid mobile number");
			System.out.println("Enter mobile number");
			customer.setCustMobile(scanner.nextLine());
		}

		System.out.println("Password should contain between 8 and 15 inclusive, contains atleast one digit, atleast one upper case and atleast one lower case and no whitespace,for e.g :STsa@123456");
		System.out.println("Enter password:");
		String password=scanner.nextLine();

		while(!(password.matches("(?=^.{8,15}$)(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?!.*\\s).*$")))
		{
			System.out.print("Please Enter Valid Password : ");
			System.out.println("Password should contain between 8 and 15 inclusive, contains atleast one digit, atleast one upper case and atleast one lower case and no whitespace,for e.g :STsa@123456");

			password=scanner.nextLine();
		}
		System.out.println("Re-enter password:");
		String repassword=scanner.nextLine();

		while(!(password.equals(repassword)))
		{
			System.out.println("Password does not match");
			System.out.println("Re-enter password:");
			repassword=scanner.nextLine();

		}
		customer.setCustPassword(password);
		System.out.println("Password generated successfully..");
		service.addCustomer(customer);
		System.out.println("Registration Successful");
		System.out.println("Welcome " + customer.getCustFirstName() + " Note down your customer ID for further process: " + customer.getCustId());
	}
	
	//updating customer
	private static CustomerMaster updateCustomer(CustomerMaster customer) throws CustomerException {
		System.out.println("Existing fname is "+customer.getCustFirstName());
		System.out.println("Enter new fname: ");
		customer.setCustFirstName(scanner.nextLine());
		CustomerMaster  updatedCustomer= service.updateCustomer(customer);
		return updatedCustomer;
	}

	//Showing All Customers Details
	private static List<CustomerMaster> getAllCustomer() throws CustomerException {
		return service.getAllCustomer();
	}

	//Delete Customer Detail
	private static Integer deleteCustomer(Integer cust_id) throws CustomerException {
		return service.deleteCustomer(cust_id);
	}


	//Showing One Customer Detail
	private static CustomerMaster getCustomerById(Integer cust_id) throws CustomerException{
		return service.getCustomerById(cust_id);        
	}








}