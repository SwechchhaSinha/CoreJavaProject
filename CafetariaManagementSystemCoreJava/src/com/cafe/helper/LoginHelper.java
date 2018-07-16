package com.cafe.helper;
import java.sql.SQLException;

import com.cafe.beans.Employee;
import com.cafe.dao.impl.EmployeeDaoImpl;
import com.cafe.service.impl.EmployeeServiceImpl;
import com.cafe.ui.impl.InitialUserInterfaceImpl;

public class LoginHelper {
	public String Login(String employeeEin, String password) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=new Employee();
		employee=employeeDaoImpl.searchEmployee(employeeEin);
		if(employee==null)
			return "User does not exist. Please sign up!!";
			
		if(employee.getPassword().equals(password)&&employee.getEIN().equals(employeeEin))
		{
			return "Login Successful";
		}
		else
		{
			return "Please enter correct password";

		}
	}
}