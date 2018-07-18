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

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	@Override
	public boolean Login(String employeeEin, String password) 
			throws ClassNotFoundException, SQLException
	{
		LoginHelper login=new LoginHelper();
		boolean ans=login.Login(employeeEin, password);
		return ans;
	}
	@Override
	public Employee searchEmployee(String employeeId) throws ClassNotFoundException, SQLException
	{
		
		Employee employee=employeeDaoImpl.searchEmployee(employeeId);
		if(employee==null)
			return null;
		else
			return employee;
	}
	@Override
	public Menu displayMenu(String employeeId) throws ClassNotFoundException, SQLException
	{
		//EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Employee employee=new Employee();
		employee=employeeDaoImpl.searchEmployee(employeeId);
		Menu menu=new Menu();
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String day="Day_"+dayOfWeek;
		MenuDaoImpl menuDaoImpl=new MenuDaoImpl();
		menu=menuDaoImpl.searchMenu(day);
		return menu;
	}
	@Override
	public boolean signupEmployee(Employee employee) throws ClassNotFoundException, SQLException
	{
		//EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
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
	///Rahul's 
		//EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		static int receiptNo = 0;
		public void generateReceiptNo(String ein) throws ClassNotFoundException, SQLException{
//			Employee currentEmployee= employeeDaoImpl.searchEmployee(ein);
			System.out.println("Thank you for coming! Your Receipt no. is: " +  ++receiptNo);
		}
		public void totalMonthlyExpense(String ein) throws ClassNotFoundException, SQLException{
			Employee currentEmployee= employeeDaoImpl.searchEmployee(ein);
			employeeDaoImpl.updateEmployee(ein, currentEmployee.getMonthlyFoodExpense()+100);
		} 
}
