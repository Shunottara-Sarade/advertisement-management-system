package com.cg.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;
    
    @Column(name = "staff_first_name" , nullable = false)
    private String firstName;
    
    @Column(name = "staff_last_name" , nullable = false)
    private String lastName;
    
    @Column(name = "staff_email" , nullable = false)
    private String email;
    
    @Column(name = "staff_mobile_no" )
    private String mobileNo;
    
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Column(name = "password" , nullable = false)
    private String password;
    
    @OneToMany(mappedBy = "staff")
    private Set<AdvertisementDetails> advertisement;

	public Staff() {
		super();
	}

	public Staff(Integer staffId, String firstName, String lastName, String email, String mobileNo, Role role,
			String password) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.role = role;
		this.password = password;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public Set<AdvertisementDetails> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Set<AdvertisementDetails> advertisement) {
		this.advertisement = advertisement;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", role=" + role + ", password=" + password + "]";
	}
    
    
}
