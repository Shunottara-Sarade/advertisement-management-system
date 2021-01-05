package com.cg.training.pl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.training.entity.Role;
import com.cg.training.entity.Staff;
import com.cg.training.exception.StaffException;
import com.cg.training.service.StaffService;
import com.cg.training.service.StaffServiceImpl;

 
public class StaffCRUDTester
{
    private static Scanner scanner=new Scanner(System.in);
    private static StaffService staffService=new StaffServiceImpl();
    private static Logger plLogger= Logger.getLogger(StaffCRUDTester.class);
    public static void main(String[] args) 
    {
        while(true) {
            System.out.println("Enter 1. Add staff 2. List staff by Id 3. Delete staff 4. List all staffs 5. Update staff");
            int option= Integer.parseInt(scanner.nextLine());
            try 
            {
                switch(option) 
                {
                case 1: Staff staff=new Staff();
                addStaff(staff);
                //System.out.println("New Product Added staff: ");
                plLogger.info("1 staff added");
                break;
                
                case 2: System.out.println("Enter staff Id");
                Integer staffId = Integer.parseInt(scanner.nextLine());
                staff= getStaffById(staffId);                        
                System.out.println(staff);
                plLogger.info("1 staff fetched");
                
                break;
                case 3: System.out.println("Enter staff id: ");
                staffId= Integer.parseInt(scanner.nextLine());
                int id= deleteStaff(staffId);
                //System.out.println("Staff: "+id+" deleted");
                plLogger.info("Staff: "+id+" deleted");
                break;
                
                case 4: List<Staff> staffList= getAllStaff();
                staffList.stream().forEach(System.out::println);
                plLogger.info("Fetching all customers");
                break;
                
                case 5: System.out.println("Enter staff id to be updated: ");
                staffId= Integer.parseInt(scanner.nextLine());
                staff= getStaffById(staffId);    
                Staff updatedStaff= updateStaff(staff);
                System.out.println(updatedStaff);
                plLogger.info(staffId+" updated");
                break;
                
                default: System.out.println("Invalid option");
                break;                

 

                }

            }catch(StaffException e)
            {
                e.printStackTrace();
            }

 

            System.out.println("Enter y to continue..");
            String ch=scanner.nextLine();
            if(!ch.equalsIgnoreCase("y")) 
            {
                break;
            }

 


        }



    }
    private static Staff updateStaff(Staff staff) throws StaffException 
    {
        System.out.println("Existing fname is "+staff.getFirstName());
        System.out.println("Enter new fname: ");
        staff.setFirstName(scanner.nextLine());
        Staff  updatedStaff= staffService.updateStaff(staff);
        return updatedStaff;

 

    }
    private static List<Staff> getAllStaff() throws StaffException
    {
        return staffService.getAllStaff();
    }
    private static int deleteStaff(Integer staffId) throws StaffException 
    {

 

        return staffService.deleteStaff(staffId);
    }
    private static Staff getStaffById(Integer staffId) throws StaffException
    {

 

        return staffService.getStaffById(staffId);
    }

 

    private static void addStaff(Staff staff) throws StaffException {
        System.out.println("First letter should be capital and only characters are allowed");
        System.out.println("Enter staff first name:");
        staff.setFirstName(scanner.nextLine());
        while(!(staff.getFirstName().matches("[A-Z][a-z]*")))
        {
            System.out.println("Enter valid name");  
            System.out.println("Enter staff first name:");
            staff.setFirstName(scanner.nextLine());
        }

 

        System.out.println("Enter staff last name:");
        staff.setLastName(scanner.nextLine());
        while(!(staff.getLastName().matches( "[A-Z][a-z]*")))
        {
            System.out.println("Enter valid name");
            System.out.println("Enter staff last name:");
            staff.setLastName(scanner.nextLine());

 

        }

 

        System.out.println("Enter email:");
        staff.setEmail(scanner.nextLine());
        while(!(staff.getEmail().matches("[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+")))
        {
            System.out.println("Invalid email address");
            System.out.println("Enter email:");
            staff.setEmail(scanner.nextLine());
        }

 

        System.out.println("Enter mobile number");
        staff.setMobileNo(scanner.nextLine());
        while(!(staff.getMobileNo().matches("(0/91)?[7-9][0-9]{9}")))
        {
            System.out.println("Invalid mobile number");
            System.out.println("Enter mobile number");
            staff.setMobileNo(scanner.nextLine());
        }

 

        int choice;
        System.out.println("1.Admin\n2.Operational Team\nEnter role:");
        choice=scanner.nextInt();
        scanner.nextLine();
        if(choice==1) {
            staff.setRole(Role.ADMIN);
        }
        else if(choice==2) {
            staff.setRole(Role.OPERATION);
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
        staff.setPassword(password);
        System.out.println("Password generated successfully..");
        staffService.addStaff(staff);
    }

 

 

}