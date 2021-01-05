package com.cg.training.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="advertisement_details")

public class AdvertisementDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Integer id;
	
	@Column(name="adv_type" ,nullable=false)
	private String advType;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="adv_image")
	private byte[] advImage;
	
	@Column(name="adv_location")
	private String advLocation;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private CustomerMaster customer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staffId")
	private Staff staff;

	public AdvertisementDetails() {
		super();
	}

	public AdvertisementDetails(Integer id, String advType, String createdBy, byte[] advImage, String advLocation,
			LocalDate startDate, LocalDate endDate, CustomerMaster customer, Staff staff) {
		super();
		this.id = id;
		this.advType = advType;
		this.createdBy = createdBy;
		this.advImage = advImage;
		this.advLocation = advLocation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.staff = staff;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdvType() {
		return advType;
	}

	public void setAdvType(String advType) {
		this.advType = advType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public byte[] getImage() {
		return advImage;
	}

	public void setImage(byte[] advImage) {
		this.advImage = advImage;
	}

	public String getAdvLocation() {
		return advLocation;
	}

	public void setAdvLocation(String advLocation) {
		this.advLocation = advLocation;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate localDate) {
		this.startDate = localDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public CustomerMaster getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "AdvertisementDetails [id=" + id + ", advType=" + advType + ", createdBy=" + createdBy + ", image="
				+ Arrays.toString(advImage) + ", advLocation=" + advLocation + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", customer=" + customer + ", staff=" + staff + "]";
	}





}
