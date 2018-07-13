package com.cafe.service.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.cafe.beans.Employee;
import com.cafe.beans.Menu;
import com.cafe.dao.impl.EmployeeDaoImpl;
import com.cafe.dao.impl.MenuDaoImpl;

public class EmployeeServiceImpl {
	
	public void displayMenu(String employeeId) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=new Employee();
		employee=employeeDaoImpl.searchEmployee(employeeId);
		Menu menu=new Menu();
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String day="Day_"+dayOfWeek;
		MenuDaoImpl menuDaoImpl=new MenuDaoImpl();
		menu=menuDaoImpl.searchMenu(day);
		if(employee.getHasOpted().equalsIgnoreCase("y"))
		{
			
			//Create Display Menu Function;
		}
		if(employee.getHasOpted().equalsIgnoreCase("n"))
		{
			// Create Display Menu Function with do you want to opt??
		}
	}
	public void signupEmployee(Employee employee) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee myEmployee=new Employee();
		myEmployee=employeeDaoImpl.searchEmployee(employee.getEIN());
		if(myEmployee==null)
		{
			employeeDaoImpl.insertEmployee(employee);
		}
		else
		{
			//error message
		}
	}
}
