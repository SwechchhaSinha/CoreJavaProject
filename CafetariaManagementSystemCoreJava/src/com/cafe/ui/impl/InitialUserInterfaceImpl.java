package com.cafe.ui.impl;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cafe.beans.Employee;
import com.cafe.beans.Menu;
import com.cafe.helper.LoginHelper;
import com.cafe.service.impl.EmployeeServiceImpl;
import com.cafe.ui.InitialUserInterfcae;

public class InitialUserInterfaceImpl implements InitialUserInterfcae {

	Employee employee=new Employee();
	private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	@Override
	public void displayInitialMenu() {
		int choice = 0;
		System.out.println("Welcome to Get July 2018 Batch Cafeteria Management System ");
		System.out.println("1. Enter system as an employee ??");
		System.out.println("2. Are you a new employee ??");
		System.out.println("3. Exit.");
		Scanner scan = new Scanner(System.in);
		try {
			choice = scan.nextInt();
			performMyAction(choice);
		} catch (InputMismatchException excep) {
			System.out.println("Please enter a valid input");
		}

	}
	@Override
	public void performMyAction(int choice) {
		Scanner scan = new Scanner(System.in);
		
		String ein, password;
		switch (choice) {
		case 1:
			System.out.println("Enter your login credentials");
			ein = scan.next();
			password = scan.next();
			try {
				Boolean correctLoginCredentials=employeeServiceImpl.Login(ein, password);
				if(ein.equals("admin") && correctLoginCredentials)
				{
					afterCorrectCredentials();
					displayMenuForStock();
				}
				else if(correctLoginCredentials)
				{
					Menu menu=employeeServiceImpl.displayMenu(ein);
					employee=employeeServiceImpl.searchEmployee(ein);
					afterCorrectCredentials();
					displayMenu(menu,employee.getHasOpted());
				}
				else
				{
					displayWrongCredentials();
					displayInitialMenu();
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 2:
			System.out.println("To Sign Up please enter your EIN");
			ein = scan.next();
			try {
				employee = employeeServiceImpl.searchEmployee(ein);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(employee==null)
				{
				
					Employee emp=new Employee();
					emp.setEIN(ein);
					System.out.println("Please enter your name");
					emp.setEmployeeName(scan.next());
					System.out.println("Please enter yes and no for not opting the food");
					String str=scan.next();
					if(str.equalsIgnoreCase("yes"))
						str="y";
					else if(str.equalsIgnoreCase("no"))
						str="n";
					else
					{
						System.out.println("You have entered wrong choice!! Start over!!");
						displayInitialMenu();
					}
					emp.setHasOpted(str);
					emp.setMonthlyFoodExpense(0);
					System.out.println("Please create a password for your account");
					password=scan.next();
					emp.setPassword(password);
					try {
						boolean ans=employeeServiceImpl.signupEmployee(emp);
						if(ans)
							System.out.println("Successfully Created Account");
							System.out.println("Start your first session ");
							displayInitialMenu();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			else
			{
				System.out.println("This EIN already exist! Please login!!");
				displayInitialMenu();
			}
		case 3: System.exit(0);
		default: System.out.println("You have entered a wrong choice");
		}
	}
	@Override
	public void displayWrongCredentials() {
		System.out.println("Wrong Login Credentials");
	}
	@Override
	public void afterCorrectCredentials() {
		System.out.println("You have successfully entered login Credentials");

	}
	@Override
	public void displayMenu(Menu menu,String str) {
		System.out.println(menu);
		if(str.equals("y"))
		{
			
		}
		else
		{
			wantToOpt();
		}
	}
	@Override
	public int wantToOpt() {
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Enter 1 to opt for lunch or any other digit to sign out of the system");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException excep) {
			System.out.println("1. Please enter a valid input");
		}
		scan.close();
		return choice;
	}
@Override
	public void displayMenuForStock() {
		System.out.println("Welcome to the cafeteria management system");
		System.out.println("Press 1 to see whole stock");
		System.out.println("Press 2 to see stock category wise");
		System.out.println("Press 3 to update stock");
		System.out.println("Press 4 to enter a new item in the stock");
		System.out.println("Press 5 to delete an item from the stock");
		// still need to work
	}
}
