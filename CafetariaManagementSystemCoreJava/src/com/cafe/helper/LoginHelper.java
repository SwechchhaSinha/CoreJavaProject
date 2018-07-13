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
//			InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
//			initialUserInterfaceImpl.afterCorrectCredentials();
//			EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
//			employeeServiceImpl.displayMenu(employeeEin);
		}
		else
		{
			return false;
//			InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
//			initialUserInterfaceImpl.displayWrongCredentials();
//			initialUserInterfaceImpl.displayInitialMenu();
		}
	}
//	public boolean LoginForStock(String employeeEin, String password) throws ClassNotFoundException, SQLException
//	{
//		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
//		Employee employee=new Employee();
//		employee=employeeDaoImpl.searchEmployee(employeeEin);
//		if(employee.getEIN().equals("admin") && employee.getPassword().equals(password))
//		{
//			InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
//			initialUserInterfaceImpl.afterCorrectCredentials();
//			
//		}
//		else
//		{
//			InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
//			initialUserInterfaceImpl.displayWrongCredentials();
//			initialUserInterfaceImpl.displayInitialMenu();
//		}
//		return false;
//	}

}
