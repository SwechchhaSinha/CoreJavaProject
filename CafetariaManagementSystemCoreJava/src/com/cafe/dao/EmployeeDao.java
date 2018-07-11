package com.cafe.dao;

import java.sql.SQLException;
import java.util.List;

import com.cafe.beans.Employee;

public interface EmployeeDao
{
	List<Employee> listAllEmployees() throws ClassNotFoundException, SQLException;
	Employee searchEmployee(String id);
	boolean insertEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	boolean updateEmployee(String columnName,String value);
	boolean updateEmployee(String columnName, int value);
}
