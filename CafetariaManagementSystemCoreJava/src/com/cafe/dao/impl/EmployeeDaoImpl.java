package com.cafe.dao.impl;

import java.sql.Connection;
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
	public Employee searchEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
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
