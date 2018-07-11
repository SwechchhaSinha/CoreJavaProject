package com.cafe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.cafe.beans.Employee;
import com.cafe.dao.EmployeeDao;
import com.cafe.helper.ConnectionHelper;

public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Override
	public List<Employee> listAllEmployees() throws ClassNotFoundException, SQLException {
		Connection conn=ConnectionHelper.getConnection();
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery("Select * from employee");
		while(rs.next())
		{
			String employeeId=rs.getString(1);
			String employeeName=rs.getString(2);
			String employeeHasOpted=rs.getString(3);
			int employeeMonthlyExpense=rs.getInt(4);
			
		}
		return null;
	}

	@Override
	public Employee searchEmployee(String id) throws ClassNotFoundException, SQLException {
		Connection conn=ConnectionHelper.getConnection();
		PreparedStatement statement=conn.prepareStatement("select * from employee where ein=?");
		statement.setString(1, id);
		ResultSet rs=statement.executeQuery();
		Employee employee=null;
		while(rs.next())
		{
			String employeeId=rs.getString(1);
			String employeeName=rs.getString(2);
			String employeeHasOpted=rs.getString(3);
			int employeeMonthlyExpense=rs.getInt(4);
			String employeePassword=rs.getString(5);
			employee=new Employee(employeeId,employeeName,employeeHasOpted,employeeMonthlyExpense,employeePassword);
			
		}
	return employee;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(String ein, String value) throws SQLException, ClassNotFoundException {
		Connection conn=ConnectionHelper.getConnection();
		PreparedStatement statement=conn.prepareStatement("update  employee set has_opted=? where ein=?");
	
		statement.setString(2, value);
		statement.setString(3, ein);
		return true;
	}

	@Override
	public boolean updateEmployee(String ein, int value) throws SQLException, ClassNotFoundException {
		Connection conn=ConnectionHelper.getConnection();
		PreparedStatement statement=conn.prepareStatement("update  employee set monthly_food_expense=? where ein=?");
		
		statement.setInt(2, value);
		statement.setString(3, ein);
		return true;
	}

}
