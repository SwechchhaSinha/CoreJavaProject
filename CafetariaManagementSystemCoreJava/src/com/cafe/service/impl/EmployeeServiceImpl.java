package com.cafe.service.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.cafe.beans.AddOn;
import com.cafe.beans.Employee;
import com.cafe.beans.Menu;
import com.cafe.dao.impl.AddOnDaoImpl;
import com.cafe.dao.impl.EmployeeDaoImpl;
import com.cafe.dao.impl.MenuDaoImpl;
import com.cafe.helper.LoginHelper;
import com.cafe.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	AddOnDaoImpl addOnDaoImpl=new AddOnDaoImpl();
	@Override
	public String Login(String employeeEin, String password) 
			throws ClassNotFoundException, SQLException
	{
		LoginHelper login=new LoginHelper();
		return login.Login(employeeEin, password);
		
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
	public Menu displayMenu() throws ClassNotFoundException, SQLException
	{
	
		Menu menu=new Menu();
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		String day="DAY "+(dayOfWeek-1);
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
		//System.out.println(myEmployee);
		if(myEmployee==null)
		{
			return employeeDaoImpl.insertEmployee(employee);
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
		public int generateReceiptNo(String ein) throws ClassNotFoundException, SQLException{
//			Employee currentEmployee= employeeDaoImpl.searchEmployee(ein);
			return ++receiptNo;
		}
		@Override
		public boolean totalMonthlyExpense(String ein,int price) throws ClassNotFoundException, SQLException{
			Employee currentEmployee= employeeDaoImpl.searchEmployee(ein);
			int tprice=currentEmployee.getMonthlyFoodExpense()+price;
			return employeeDaoImpl.updateEmployee(ein,tprice );

		} 
		
		@Override
		public ArrayList<AddOn> addON() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			ArrayList<AddOn>listAllAddOn=addOnDaoImpl.listAllAddOn();
			return listAllAddOn;
		}
		@Override
		public AddOn searchAddOn(String addOnId) throws ClassNotFoundException, SQLException
		{
			AddOn addOn=addOnDaoImpl.searchAddOn(addOnId);

			return addOn;
		}
		@Override
		public int buyAddOn(String addOnId, int quantity) throws ClassNotFoundException, SQLException {
		
			AddOn a=searchAddOn(addOnId);
			
			
		if(a.getAddOnId()==null)
		{
			return 1;
		}
		else
		{
			int q=a.getAddOnQuantity();
			if(q<quantity)
				return 2;
			else
			{
				addOnDaoImpl.outputAddOn(addOnId, quantity);
				return 0;
			}
		}
	
			
		}
		@Override
		public int monthlyFoodExpense(String ein) throws ClassNotFoundException, SQLException {
			
			return employeeDaoImpl.employeeFoodExpense(ein);
		}
}
