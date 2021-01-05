package com.cg.training.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import com.cg.training.entity.AdvertisementDetails;
import com.cg.training.entity.CustomerMaster;
import com.cg.training.entity.Role;
import com.cg.training.entity.Staff;
import com.cg.training.exception.AdvertisementException;
import com.cg.training.exception.CustomerException;
import com.cg.training.exception.StaffException;
import com.cg.training.service.AdvertisementService;
import com.cg.training.service.AdvertisementServiceImpl;
import com.cg.training.service.CustomerService;
import com.cg.training.service.CustomerServiceImpl;
import com.cg.training.service.StaffService;
import com.cg.training.service.StaffServiceImpl;


public class AdvertisementCRUDTester {

	private static EntityManagerFactory EMF=
			Persistence.createEntityManagerFactory("advertisement-management-system");
	static EntityManager em=null; 

	private static Scanner scanner=new Scanner(System.in);
	private static AdvertisementService service= new AdvertisementServiceImpl();
	private static CustomerService customerService=new CustomerServiceImpl();
	private static StaffService staffService=new StaffServiceImpl();
	private static Logger plLogger= Logger.getLogger(AdvertisementCRUDTester.class);
	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter\n1. Add advertisement \n2. List advertisement by Id \n3. Delete advertisement \n4. List all advetisements \n5. Update advertisement");
			int option= Integer.parseInt(scanner.nextLine());
			try {
				switch(option) {
				case 1: AdvertisementDetails advertisement=new AdvertisementDetails();
				addAdvertisement(advertisement);
				plLogger.info("1 advertisement added");
				break;
				
				case 2: System.out.println("Enter Advertisement Id");
				Integer id = Integer.parseInt(scanner.nextLine());
				advertisement= getAdvertisementById(id);                        
				System.out.println(advertisement);
				plLogger.info("1 advertisement fetched");
				break;
				
				case 3: System.out.println("Enter Advertisement id: ");
				id= Integer.parseInt(scanner.nextLine());
				int id1= deleteAdvertisement(id);
				plLogger.info("Advertisement: "+id1+" deleted");
				break;
				
				case 4: List<AdvertisementDetails> advertisementList= getAllAdvertisement();
				advertisementList.stream().forEach(System.out::println);
				plLogger.info("Fetching all advertisement");
				break;
				
				case 5: System.out.println("Enter Advertisement id to be updated: ");
				id= Integer.parseInt(scanner.nextLine());
				advertisement= getAdvertisementById(id);    
				AdvertisementDetails Updatedadvertisement= updateAdvertisement(advertisement);
				System.out.println(Updatedadvertisement);
				plLogger.info(id+" updated");
				break;
				
				default: System.out.println("Invalid option");
				break;                

				}

			}catch(AdvertisementException e) {
				plLogger.error(e.getMessage(), e);

			}catch(CustomerException e) {
				plLogger.error(e.getMessage(), e);

			}catch(StaffException e) {
				plLogger.error(e.getMessage(), e);
			}
			System.out.println("Enter y to continue..");
			String ch=scanner.nextLine();
			if(!ch.equalsIgnoreCase("y")) {
				break;
			}

		}

	}

	//Update Advertisement
	private static AdvertisementDetails updateAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException {
		System.out.println("Existing End Date  is "+advertisement.getEndDate());
		System.out.println("Enter new end date (dd/mm/yyyy) :  ");
		String strExpiry1=scanner.nextLine();
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		advertisement.setEndDate(LocalDate.parse(strExpiry1,formatter));
		AdvertisementDetails updatedAdvertisement= service.updateAdvertisement(advertisement);
		return updatedAdvertisement;
	}

	//Get All Advertisement
	private static List<AdvertisementDetails> getAllAdvertisement() throws AdvertisementException {
		return service.getAllAdvertisement();
	}

	//Delete Advertisement
	private static int deleteAdvertisement(Integer id) throws AdvertisementException {
		return service.deleteAdvertisement(id);
	}

	//Get Advertisement By Id
	private static AdvertisementDetails getAdvertisementById(Integer id) throws AdvertisementException{
		return service.getAdvertisementById(id);        
	}

	//Add Advertisement
	private static void addAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException, StaffException, CustomerException{

		System.out.println("Enter advertisement type");
		advertisement.setAdvType(scanner.nextLine());

		System.out.println("Enter advertisement creator \n 1.Own\n2.Operation team");
		int choice=scanner.nextInt();
		scanner.nextLine();
		if(choice==1) {
			advertisement.setCreatedBy("Own");
		}
		else if(choice==2) {
			advertisement.setCreatedBy("Operation Team");
		}

		System.out.println("Enter location");
		advertisement.setAdvLocation(scanner.nextLine());
		
		//convert String to LocalDate
		System.out.println("Enter Start date(dd/mm/yyyy): ");
		String strDate=scanner.nextLine();
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");        
		advertisement.setStartDate(LocalDate.parse(strDate, formatter));
		
		System.out.println("Enter end date(dd/mm/yyyy): ");
		String strExpiry=scanner.nextLine();
		advertisement.setEndDate(LocalDate.parse(strExpiry,formatter));
		
		System.out.println("Enter customer id");
		Integer cid=scanner.nextInt();
		CustomerMaster customerMaster=customerService.getCustomerById(cid);
		advertisement.setCustomer(customerMaster);

		if(advertisement.getCreatedBy().equalsIgnoreCase("own")) {
			advertisement.setStaff(null);
		}
		else {
			System.out.println("Enter staff id");
			int sid= Integer.parseInt(scanner.nextLine());
			Staff staff=staffService.getStaffById(sid);
			advertisement.setStaff(staff);
		}
		//advertisement.setId(null);
		service.addAdvertisement(advertisement);

	}
}

