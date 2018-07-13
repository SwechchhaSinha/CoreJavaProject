package com.cafe.service;

import java.sql.SQLException;
import java.util.List;

import com.cafe.beans.Employee;

public interface EmployeeService
{
	
	public void displayMenu(String employeeId) throws ClassNotFoundException, SQLException;
	public boolean signupEmployee(Employee employee) throws ClassNotFoundException, SQLException;

	//rahul's:
	public void generateReceiptNo(String ein) throws ClassNotFoundException, SQLException;
	public void totalMonthlyExpense(String ein)throws ClassNotFoundException, SQLException;
}
/*
 * 
 --
Login ke lie func in helper
display menu if opted diff screen and not opted diff screen 
Signup of employee
addondisplay
--rahul
generate receipt number
addon ke sath monthly expense update krne h <opted / not opted expense>

*/

/*


Stock point of view:
display Food table
display Food table acc to category
----
---swechchha
update menu 
Stock Manager Input stock func which will update food table as well as insert transaction table
Stock Manager Output stock func which will update food table
Generate report will fetch details from transaction table as per date and put data in a flat file.
 */