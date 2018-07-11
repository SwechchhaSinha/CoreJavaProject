package com.cafe.dao;

import java.sql.SQLException;
import java.util.List;

import com.cafe.beans.Employee;

public interface EmployeeDao
{
	List<Employee> listAllEmployees() throws ClassNotFoundException, SQLException;
	Employee searchEmployee(String id) throws ClassNotFoundException, SQLException;
	boolean insertEmployee(Employee employee);
	boolean updateEmployee(String ein,String value) throws SQLException, ClassNotFoundException;
	boolean updateEmployee(String columnName, int value) throws SQLException, ClassNotFoundException;
}
