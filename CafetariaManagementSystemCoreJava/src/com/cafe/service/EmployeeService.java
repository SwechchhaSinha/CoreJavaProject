package com.cafe.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe.beans.AddOn;
import com.cafe.beans.Employee;
import com.cafe.beans.Menu;

public interface EmployeeService
{
	
	
	public boolean signupEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	public int generateReceiptNo(String ein) throws ClassNotFoundException, SQLException;
	public boolean totalMonthlyExpense(String ein)throws ClassNotFoundException, SQLException;
	String Login(String employeeEin, String password) throws ClassNotFoundException, SQLException;
	Employee searchEmployee(String employeeId) throws ClassNotFoundException, SQLException;
	public ArrayList<AddOn> addON() throws ClassNotFoundException, SQLException;
	AddOn searchAddOn(String addOnId) throws ClassNotFoundException, SQLException;
	Menu displayMenu() throws ClassNotFoundException, SQLException;
	int buyAddOn(String addOnId,int quantity) throws ClassNotFoundException, SQLException;
}
