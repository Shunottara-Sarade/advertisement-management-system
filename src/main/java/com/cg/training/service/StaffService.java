package com.cg.training.service;

import java.util.List;

import com.cg.training.entity.Staff;
import com.cg.training.exception.StaffException;

public interface StaffService 
{
	public void addStaff(Staff staff) throws StaffException;
	public Staff getStaffById(Integer staffId) throws StaffException;
	public Integer deleteStaff(Integer staffId) throws StaffException;
	public List<Staff> getAllStaff() throws StaffException;
	public Staff updateStaff(Staff staff) throws StaffException;
}
