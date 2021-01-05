package com.cg.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_master")

//POJO Class
public class CustomerMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	@Column(name="cust_first_name", nullable=false)
	private String custFirstName;
	
	@Column(name="cust_last_name", nullable=false)
	private String custLastName;
	
	@Column(name="cust_email")
	private String custEmail;
	
	@Column(name="cust_mobile")
	private String custMobile;
	
	@Column(name="cust_password")
	private String custPassword;
	
	@OneToMany(mappedBy = "customer")
	private Set<AdvertisementDetails> advertisement;

	public CustomerMaster() {

	}

	
	public CustomerMaster(Integer custId, String custFirstName, String custLastName, String custEmail, String custMobile,
			String custPassword) {
		super();
		this.custId = custId;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custEmail = custEmail;
		this.custMobile = custMobile;
		this.custPassword = custPassword;
	}
	


	public Integer getCustId() {
		return custId;
	}


	public void setCustId(Integer custId) {
		this.custId = custId;
	}


	public String getCustFirstName() {
		return custFirstName;
	}


	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}


	public String getCustLastName() {
		return custLastName;
	}


	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}


	public String getCustEmail() {
		return custEmail;
	}


	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


	public String getCustMobile() {
		return custMobile;
	}


	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}


	public String getCustPassword() {
		return custPassword;
	}


	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}


	public Set<AdvertisementDetails> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Set<AdvertisementDetails> advertisement) {
		this.advertisement = advertisement;
	}


	@Override
	public String toString() {
		return "CustomerMaster [custId=" + custId + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custEmail=" + custEmail + ", custMobile=" + custMobile + ", custPassword="
				+ custPassword + "]";
	}
	







}
