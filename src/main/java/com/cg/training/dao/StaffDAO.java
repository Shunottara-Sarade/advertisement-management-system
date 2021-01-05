package com.cg.training.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.training.entity.Staff;

public interface StaffDAO
{
	public void addStaff(Staff staff) throws PersistenceException;
	public Staff getStaffById(Integer staffId) throws PersistenceException;
	public Integer deleteStaff(Integer staffId) throws PersistenceException;
	public List<Staff> getAllStaff() throws PersistenceException;
	public Staff updateStaff(Staff staff) throws PersistenceException;
}
