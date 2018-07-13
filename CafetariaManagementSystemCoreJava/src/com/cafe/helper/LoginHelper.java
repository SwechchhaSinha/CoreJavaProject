package com.cafe.helper;

import java.sql.SQLException;

import com.cafe.beans.Employee;
import com.cafe.dao.impl.EmployeeDaoImpl;

public class LoginHelper {
	public boolean Login(String employeeEin, String password) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=new Employee();
		employee=employeeDaoImpl.searchEmployee(employeeEin);
		if(employee.getEIN().equals(employeeEin) && employee.getPassword().equals(password))
		{
			//welcome to your screen
		}
		else
		{
			//Wrong Credentials
		}
		return false;
	}
}
