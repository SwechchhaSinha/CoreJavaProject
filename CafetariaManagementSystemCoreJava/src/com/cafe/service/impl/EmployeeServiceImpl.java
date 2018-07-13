package com.cafe.service.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.cafe.beans.Employee;
import com.cafe.beans.Menu;
import com.cafe.dao.impl.EmployeeDaoImpl;
import com.cafe.dao.impl.MenuDaoImpl;
import com.cafe.helper.LoginHelper;
import com.cafe.service.EmployeeService;
import com.cafe.ui.impl.InitialUserInterfaceImpl;

public class EmployeeServiceImpl implements EmployeeService {
	public boolean Login(String employeeEin, String password) 
			throws ClassNotFoundException, SQLException
	{
		LoginHelper login=new LoginHelper();
		boolean ans=login.Login(employeeEin, password);
		return ans;
	}
	public boolean searchEmployee(String employeeId) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=employeeDaoImpl.searchEmployee(employeeId);
		if(employee==null)
			return true;
		else
			return false;
	}
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
			InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
			initialUserInterfaceImpl.displayMenu(menu);
		}
		if(employee.getHasOpted().equalsIgnoreCase("n"))
		{
			InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
			initialUserInterfaceImpl.displayMenu(menu);
			int choice=initialUserInterfaceImpl.wantToOpt();
			if(choice==1)
			{
				//Generate Receipt
			}
			else
			{
				//System.exit();
			}
		}
	}
	public boolean signupEmployee(Employee employee) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee myEmployee=new Employee();
		myEmployee=employeeDaoImpl.searchEmployee(employee.getEIN());
		if(myEmployee==null)
		{
			employeeDaoImpl.insertEmployee(employee);
			return true;
		}
		else
		{
			//error message
			return false;
		}
	}
	@Override
	public void generateReceiptNo(String ein) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void totalMonthlyExpense(String ein) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
}
