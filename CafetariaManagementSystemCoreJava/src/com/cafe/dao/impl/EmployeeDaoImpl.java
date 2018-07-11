package com.cafe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe.beans.Employee;
import com.cafe.dao.EmployeeDao;
import com.cafe.helper.ConnectionHelper;

public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Override
	public List<Employee> listAllEmployees() throws ClassNotFoundException, SQLException {
		Connection conn=ConnectionHelper.getConnection();
		Statement statement=conn.createStatement();
		ArrayList<Employee> employees=new ArrayList<>();
		ResultSet rs=statement.executeQuery("Select * from employee");
		while(rs.next())
		{
			String employeeId=rs.getString(1);
			String employeeName=rs.getString(2);
			String employeeHasOpted=rs.getString(3);
			int employeeMonthlyExpense=rs.getInt(4);
			String password=rs.getString(5);
			Employee employee=new Employee(employeeId,employeeName,
					employeeHasOpted,employeeMonthlyExpense,password);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public Employee searchEmployee(String id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertEmployee(Employee employee) throws ClassNotFoundException, SQLException 
	{
		Connection conn=ConnectionHelper.getConnection();
		PreparedStatement statement=conn.prepareStatement("Insert into employee"
				+ "values(?,?,?,?,?)");
		
		statement.setString(1, employee.getEIN());
		statement.setString(2, employee.getEmployeeName());
		statement.setString(3, employee.getHasOpted());
		statement.setInt(4, employee.getMonthlyFoodExpense());
		statement.setString(5, employee.getPassword());
		int rows=statement.executeUpdate();
		
		if(rows <= 0)
			return false;		
		else
			return true;
	}

	@Override
	public boolean updateEmployee(String columnName, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(String columnName, int value) {
		// TODO Auto-generated method stub
		return false;
	}

}
