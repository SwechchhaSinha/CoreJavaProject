package com.cafe.ui.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cafe.beans.Employee;
import com.cafe.beans.Menu;
import com.cafe.service.impl.EmployeeServiceImpl;
import com.cafe.ui.InitialUserInterfcae;

public class InitialUserInterfaceImpl implements InitialUserInterfcae {
	Scanner scan = new Scanner(System.in);

	Employee employee = new Employee();
	private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	private StockManagerUiImpl1 stockManagerUiImpl1 = new StockManagerUiImpl1();
	private StockManagerUiImpl stockManagerUiImpl = new StockManagerUiImpl();

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
			performInitialAction(choice);
		} catch (InputMismatchException excep) {
			System.out.println("Please enter a valid input");
		}

	}

	@Override
	public void performInitialAction(int choice) {
		Scanner scan = new Scanner(System.in);

		String ein = null, password = null;
		switch (choice) {
		case 1:
			System.out.println("Enter your login credentials");
			System.out.println("Enter your username");
			
				ein = scan.next();
				System.out.println("Enter your password");
				password = scan.next();
		
			try {
				String correctLoginCredentials = employeeServiceImpl.Login(ein, password);
				if (ein.equals("admin") && correctLoginCredentials.equals("Login Successful")) {
					System.out.println(correctLoginCredentials);
					displayMenuForStock();
				} else if (correctLoginCredentials.equals("Login Successful")) {
					Menu menu = employeeServiceImpl.displayMenu(ein);
					employee = employeeServiceImpl.searchEmployee(ein);
					afterCorrectCredentials();
					displayMenu(menu, employee.getHasOpted(), ein);

				} else {
					System.out.println(correctLoginCredentials);
					displayInitialMenu();
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error : "+e.getMessage());
			}
			break;
		case 2:
			System.out.println("To Sign Up please enter your EIN");
			ein = scan.next();
			try {
				employee = employeeServiceImpl.searchEmployee(ein);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error : "+e.getMessage());
			}
			if (employee == null) {

				Employee emp = new Employee();
				emp.setEIN(ein);
				System.out.println("Please enter your name");
				emp.setEmployeeName(scan.next());
				System.out.println("Please enter yes and no for not opting the food");
				String str = scan.next();
				if (str.equalsIgnoreCase("yes"))
					str = "y";
				else if (str.equalsIgnoreCase("no"))
					str = "n";
				else {
					System.out.println("You have entered wrong choice!! Start over!!");
					displayInitialMenu();
				}
				emp.setHasOpted(str);
				emp.setMonthlyFoodExpense(0);
				System.out.println("Please create a password for your account");
				password = scan.next();
				emp.setPassword(password);
				try {
					boolean ans = employeeServiceImpl.signupEmployee(emp);
					if (ans)
						System.out.println("Successfully Created Account");
					System.out.println("Start your first session ");
					displayInitialMenu();
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println("Error : "+e.getMessage());
				}

			} else {
				System.out.println("This EIN already exist! Please login!!");
				displayInitialMenu();
			}
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("You have entered a wrong choice");
			break;
		}
	}

	@Override
	public void displayWrongCredentials() {
//		System.out.println("Wrong Login Credentials");
	}

	@Override
	public void afterCorrectCredentials() {
		//System.out.println("You have successfully entered login Credentials");

	}

	@Override
	public void displayMenu(Menu menu, String str, String ein) {
		System.out.println(menu);
		if (str.equals("y")) {

		} else {
			int ans = wantToOpt();
			if (ans == 1)
				try {
					int recieptNo=employeeServiceImpl.generateReceiptNo(ein);
					boolean status=employeeServiceImpl.totalMonthlyExpense(ein);
					
					if(status==true)
					{
						System.out.println("Thank you for coming! Your Receipt no. is: " +  recieptNo);
						System.out.println("Cost of food added to monthly expense!!");
					}
					else
						System.out.println("Sorry , please try again!");
						
				} catch (ClassNotFoundException | SQLException e) {
					
					System.out.println("Error : "+e.getMessage());
				}

		}
	}

	@Override
	public int wantToOpt() {
		int choice = 0;

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
		int choice = 0;
		System.out.println("Welcome to the Cafeteria Management System");
		System.out.println("Press 1 to view stock.");
		System.out.println("Press 2 to generate report of daily transactions");
		System.out.println("Press 3 to update stock");
		System.out.println("Press 4 to update menu");
		System.out.println("Press 5 to take out stock");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("Please enter a valid input");
		}
		switch (choice) {
		case 1:
			try {
				stockManagerUiImpl.displayStock();
			} catch (ClassNotFoundException | SQLException e) {
				
				System.out.println("Error : "+e.getMessage());
			}
			break;
		case 2:
			
			try {
				stockManagerUiImpl.generateReport();
			} catch (ClassNotFoundException | SQLException | IOException e) {
				
				System.out.println("Error : "+e.getMessage());
			}
			break;
		case 3:
			try {
				stockManagerUiImpl.updateStock();
			} catch (ClassNotFoundException | SQLException e) {

			}
			break;
		case 4:
			stockManagerUiImpl1.updateMenu();
			break;
		case 5:
			stockManagerUiImpl1.outputStock();
		}

	}
}
