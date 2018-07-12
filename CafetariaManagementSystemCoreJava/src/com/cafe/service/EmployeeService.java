package com.cafe.service;

import java.util.List;

import com.cafe.beans.Employee;

public interface EmployeeService
{
	List<Employee> listAllEmployees();

	Employee searchEmployeeById(String employeeId);

	boolean insertEmployee(Employee employee);

	boolean updateEmployee(String id, String value);

	boolean updateEmployee(String id, int value);
}
