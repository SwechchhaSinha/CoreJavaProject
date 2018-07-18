package com.cafe.ui.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cafe.beans.AddOn;
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

		System.out.println("WELCOME TO GET JULY 2018 CAFETERIA MANAGEMENT SYSTEM : ");
		System.out.println("1. Login as Employee/Stock Manager");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit.");

		try {
			int choice = scan.nextInt();
			performInitialAction(choice);
		} catch (InputMismatchException excep) {
			System.out.println("Please enter a valid input");
		}

	}

	@Override
	public void performInitialAction(int choice) {

		String ein = null, password = null;
		switch (choice) {
		case 1:
			System.out.println("ENTER LOGIN CREDENTIALS :");
			System.out.println("Enter your username :");
			ein = scan.next();
			System.out.println("Enter your password :");
			password = scan.next();

			try {
				String correctLoginCredentials = employeeServiceImpl.Login(ein, password);
				if (ein.equals("admin") && correctLoginCredentials.equals("Login Successful")) {
					System.out.println(correctLoginCredentials);
					displayMenuForStock();
				} else if (correctLoginCredentials.equals("Login Successful")) {

					employee = employeeServiceImpl.searchEmployee(ein);
					String optStatus = employee.getHasOpted();
					System.out.println(correctLoginCredentials);
					displayMenu();
					haveFood(optStatus, ein);

				} else {
					System.out.println(correctLoginCredentials);
					displayInitialMenu();
				}
			} catch (InputMismatchException | ClassNotFoundException | SQLException e) {

				System.out.println("Error : " + e.getMessage());

			}
			break;
		case 2:

			System.out.println("To Sign Up please enter your EIN");
			ein = scan.next();
			try {
				employee = employeeServiceImpl.searchEmployee(ein);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error : " + e.getMessage());
			}
			if (employee == null) {
				while (true) {
					Employee emp = new Employee();
					emp.setEIN(ein);
					System.out.println("Please enter your name");
					emp.setEmployeeName(scan.next());
					while (true) {
						System.out.println("Do you want to avail monthly food facility? (Y/N)");

						String str = scan.next();
						if (str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("N")) {
							emp.setHasOpted(str);
							break;
						} else {
							System.out.println("You have entered wrong choice!! Please start over!!");
							continue;
						}
					}

					emp.setMonthlyFoodExpense(0);
					System.out.println("Please create a password for your account");
					password = scan.next();
					emp.setPassword(password);
					try {
						boolean ans = employeeServiceImpl.signupEmployee(emp);
						if (ans) {
							System.out.println("Successfully Created Account");
							System.out.println("Please login to continue");
							displayInitialMenu();

							break;
						} else {
							System.out.println("Oops!!..Some problem has occured. Please try again");
							continue;
						}

					} catch (ClassNotFoundException | SQLException e) {
						System.out.println("Error : " + e.getMessage());

					}
				}

			} else {
				System.out.println("This EIN already exist! Please login!!");

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
	public void displayMenu() {
		Menu menu;
		try {
			menu = employeeServiceImpl.displayMenu();
			System.out.println(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void haveFood(String str, String ein) {
		if (str.equalsIgnoreCase("y")) {
			
			while (true) {
				System.out.println("Would you like to have ice cream/cold drink?? (Chargeable)");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int choice = scan.nextInt();
				if (choice == 1) {
					displayAddOn();
					System.out.println("Enjoy your Food!!");
					break;
				} else if (choice == 2) {
					System.out.println("Enjoy your lunch!!");
					break;
				} else {
					System.out.println("You haven't entered a valid option. Please try again.");
					continue;
				}
			}
		} else {
			while(true)
			{
			int ans = wantToOpt();
			
			if (ans == 1) {
				System.out.println("Enjoy your lunch!!");
				System.out.println("Would you like to have ice cream/cold drink?? (Chargeable)\nPress 1 to continue else press any other no.");
				int ch = scan.nextInt();
				if (ch == 1)
					displayAddOn();
				else 
					System.out.println("You haven't taken any additional item. Your reciept for lunch is generated.");
				try {
					int recieptNo = employeeServiceImpl.generateReceiptNo(ein);
					boolean status = employeeServiceImpl.totalMonthlyExpense(ein);

					if (status == true) {
						System.out.println("Thank you for coming! Your Receipt no. is: " + recieptNo);
						System.out.println("Cost of food added to monthly expense!!");
					} else {
						System.out.println("Sorry , please try again!");
					}

				} catch (ClassNotFoundException | SQLException e) {

					System.out.println("Error : " + e.getMessage());
				}
				break;
			}
			else if(ans==2)
			{
				System.out.println("Would you like to have ice cream/cold drink?? (Chargeable)\nPress 1 to continue");
				int ch = scan.nextInt();
				if (ch == 1)
					displayAddOn();
				else
					System.out.println("Thank you for coming!! You have been logged out!!!");
				break;
			}
			
			else
			{
				System.out.println("Please enter a valid choice!!");
				continue;
			}
			}	
				
		}
	}

	@Override
	public int wantToOpt() {
		int choice = 0;

		System.out.println(" Would you like to have lunch? (Chargeable)");
		System.out.println("1. Yes");
		System.out.println("2. No");
		
		try {
			choice = scan.nextInt();
			
		} catch (Exception excep) {

			System.out.println("Please enter a valid input");
			scan.next();
			return -1;
		}

		return choice;
	}

	@Override
	public void displayMenuForStock() {
		label2:while(true)
		{
		int choice = 0;
		System.out.println("Welcome to the Cafeteria Management System");
		System.out.println("Press 1 to view stock.");
		System.out.println("Press 2 to generate report of daily transactions");
		System.out.println("Press 3 to update stock");
		System.out.println("Press 4 to update menu");
		System.out.println("Press 5 to take out stock");
		System.out.println("Press 6 to sign out from the System");
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

				System.out.println("Error : " + e.getMessage());
			}
			break;
		case 2:

			try {
				stockManagerUiImpl.generateReport();
			} catch (ClassNotFoundException | SQLException | IOException e) {

				System.out.println("Error : " + e.getMessage());
			}
			break;
		case 3:

			stockManagerUiImpl.updateStock();

			break;
		case 4:
			stockManagerUiImpl1.updateMenu();
			break;
		case 5:
			stockManagerUiImpl1.outputStock();
			break;
		case 6:
			System.out.println("You have successfully logged out of the system");
			System.exit(0);
		}
		label1:while(true)
		{
		System.out.println("Do you want to continue??? (Y/N)");
		String ch=scan.next();
		if(ch.equalsIgnoreCase("y"))
			continue label2;
		else if(ch.equalsIgnoreCase("n"))	
		{
			System.out.println("You have been logged out of the system. Thank You.");
			break label2;
		}
		else
		{
			System.out.println("Please enter valid choice");
			continue label1;
		}
		}
		}

	}

	@Override
	public void displayAddOn() {
		ArrayList<AddOn> addOn = new ArrayList<>();
		try {

			addOn = employeeServiceImpl.addON();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		while (true) {
			for(AddOn add:addOn)
				System.out.println(add);

			System.out.println("Enter the id of Add On you want to have");
			String addOnId = scan.next();
			System.out.println("Enter the quantity :");
			int quantity=scan.nextInt();
			try {
			
				boolean result=employeeServiceImpl.buyAddOn(addOnId, quantity);
				if (result == false) {
					System.out.println("Add on not available.\n Please get yourself something else");
					continue;
					
				} else {
					
					System.out.println("Thank you!! Charges will be added to your account.");
				} 
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Some error has occured");
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want anything else?? (Y/N)");
			String choice = scan.next();
			if (choice.equalsIgnoreCase("Y"))
				continue;
			else if (choice.equalsIgnoreCase("N"))
				break;
			else {
				System.out.println("Please enter a valid option.");
				continue;
			}
		}

	}

}
