package com.cafe.helper;
import java.sql.SQLException;

import com.cafe.beans.Employee;
import com.cafe.dao.impl.EmployeeDaoImpl;
import com.cafe.service.impl.EmployeeServiceImpl;
import com.cafe.ui.impl.InitialUserInterfaceImpl;

public class LoginHelper {
	public boolean Login(String employeeEin, String password) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=new Employee();
		employee=employeeDaoImpl.searchEmployee(employeeEin);
		if(employee.getEIN().equals(employeeEin)&& employee.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;

		}
	}
}