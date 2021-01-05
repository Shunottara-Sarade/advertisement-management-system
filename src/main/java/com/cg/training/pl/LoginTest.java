package com.cg.training.pl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.training.entity.CustomerMaster;
import com.cg.training.entity.Staff;
import com.cg.training.service.CustomerServiceImpl;
import com.cg.training.service.StaffServiceImpl;

public class LoginTest {
	private static Scanner scanner=new Scanner(System.in);
	private static Logger plLogger= Logger.getLogger(LoginTest.class);
	private static CustomerMaster customer;
	private static CustomerServiceImpl service=new CustomerServiceImpl();
	private static Staff staff;
	private static StaffServiceImpl staffService=new StaffServiceImpl();
	public static void main(String[] args) {
		
		System.out.println("1.Login as Customer \n2.Login as Staff");
		int op=Integer.parseInt(scanner.nextLine());
		try {
			switch(op) {
			case 1:
				System.out.println("Enter your id: ");
				Integer id=scanner.nextInt();
				customer=service.getCustomerById(id);

				if(customer!=null) {
					System.out.println("Valid ID");
					System.out.println("Enter Password");
					String pass=scanner.nextLine();
					if(pass.equals(customer.getCustPassword())) {
						System.out.println("Valid Password");
						System.out.println("Valid Customer");
					}
					else {
						System.out.println("Invalid Customer");

					}


				}
				else {
					System.out.println("Invalid Customer");

				}
				break;
			case 2:

				System.out.println("Enter your id: ");
				Integer id1=Integer.parseInt(scanner.nextLine());
				staff=staffService.getStaffById(id1);

				if(staff!=null) {
					System.out.println("Valid ID");
					System.out.println("Enter Password");
					String pass=scanner.nextLine();
					if(pass.equals(staff.getPassword())) {
						System.out.println("Valid Password");
						System.out.println("Valid Staff");
					}
					else {
						System.out.println("Invalid Staff");
						System.out.println("Enter Proper Credentials");

					}


				}
				else {
					System.out.println("Invalid Staff");

				}
				break;
			default:
				System.out.println("Invalid choice");

			}
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}



