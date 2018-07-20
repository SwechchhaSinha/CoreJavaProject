package com.cafe.ui.impl;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cafe.beans.Food;
import com.cafe.beans.Transaction;
import com.cafe.service.impl.StockManagerServiceImpl;
import com.cafe.ui.StockManagerUi;

public class StockManagerUiImpl implements StockManagerUi {
	Scanner sc = new Scanner(System.in);
	StockManagerServiceImpl stockManagerServiceImpl = new StockManagerServiceImpl();

	@Override
	public void displayStock() throws ClassNotFoundException, SQLException {

		System.out.println("1. All \n2. Categorywise");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Present Stock:");
			System.out.println(String.format("%-10s|", "FOOD_ID") + 
				String.format("%-15s|", "NAME") + String.format("%-15s|", "CATEGORY") 
				+ String.format("%-10s|", "QUANTITY"));
			System.out.println("------------------------------------------------------");
			
			List<Food> foodList = stockManagerServiceImpl.displayFood();
			for (Food food : foodList) {
				System.out.println(food);
			}
			break;
		case 2:
			while (true) {
				int categoryChoice;
				System.out.println("Enter category: ");
				System.out.println("Enter 1 for Vegetable");
				System.out.println("Enter 2 for Grains");
				System.out.println("Enter 3 for Spices");
				if(sc.hasNextInt())
				{	categoryChoice = sc.nextInt();
				String category = null; // Have to check for char input
				if (categoryChoice == 1)
					category = "Vegetable";
				else if (categoryChoice == 2)
					category = "Grains";
				else if (categoryChoice == 3)
					category = "Spices";
				else {
					System.out.println("Please enter a valid choice");
					continue;
				}
				System.out.println("Present "+category+" stock:");
				System.out.println(String.format("%-10s|", "FOOD_ID") + 
						String.format("%-15s|", "NAME") + String.format("%-15s|", "CATEGORY") 
						+ String.format("%-10s|", "QUANTITY"));
					System.out.println("------------------------------------------------------");
				List<Food> foodList1 = stockManagerServiceImpl.displayFood(category);
				for (Food food : foodList1) {
					System.out.println(food);
				}
				}
				else
				{
					System.out.println("Please enter a valid choice");
					sc.next();
					continue;
				}
				break;
			}
			break;
		default:
			System.out.println("Please enter the right choice.");
		}

	}

	public void updateStock() {
		System.out.println("1. Insert new stock" + "2. Update Existing stock" + "3. Delete Existing stock");
		int choice = sc.nextInt();
		boolean status = false;
		System.out.println("Present Stock:");
		System.out.println(String.format("%-10s|", "FOOD_ID") + 
			String.format("%-15s|", "NAME") + String.format("%-15s|", "CATEGORY") 
			+ String.format("%-10s|", "QUANTITY"));
		System.out.println("------------------------------------------------------");
		
		List<Food> foodList=null;
		try {
			foodList = stockManagerServiceImpl.displayFood();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (Food food : foodList) {
			System.out.println(food);
		}
		switch (choice) {
		case 1:
			System.out.println("Enter Food_Id");
			String fId = sc.next();
			System.out.println("Enter food name");
			String fName = sc.next();
			System.out.println("Enter food category");
			System.out.println("Valid food category");
			System.out.println("Vegetable");
			System.out.println("Grains");
			System.out.println("Spices");
			String fCategory = sc.next();
			int fQty=0,fPrice=0;
			LocalDate fDate=LocalDate.now();
			if (fCategory.equalsIgnoreCase("vegetable") || fCategory.equalsIgnoreCase("spices")
					|| fCategory.equalsIgnoreCase("grains")) {
				System.out.println("Enter food quantity");
				fQty = sc.nextInt();
				Food food = new Food(fId.toUpperCase(), fName, fCategory, fQty);
				System.out.println("Enter price: ");
				 fPrice = sc.nextInt();
				
				try {
					status = stockManagerServiceImpl.inputStock(food, fPrice, fDate);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (status)
					System.out.println("Stock inserted successfully");
				else
					System.out.println("Stock not inserted; Check your details again");
			} else {
					System.out.println("This category is not valid! Please enter a valid category");
					updateStock();
			}
			break;
		case 2:
			System.out.println("Enter Food_Id");
			fId = sc.next();
			System.out.println("Enter food quantity");
			fQty = sc.nextInt();
			System.out.println("Enter price: ");
			fPrice = sc.nextInt();

			LocalDate date = LocalDate.now();
			try {

				status = stockManagerServiceImpl.updateStock(fId.toUpperCase(), fQty, fPrice, date);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (status)
				System.out.println("Stock updated successfully");
			else
				System.out.println("Stock not updated; Check your details again.");
			break;
		case 3:
			System.out.println("Enter Food_Id");
			fId = sc.next();
			try {
				status = stockManagerServiceImpl.deleteStock(fId.toUpperCase());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (status)
				System.out.println("Stock deleted successfully");
			else
				System.out.println("Stock not deleted; Check your Food_Id again");
			break;
		default:
			System.out.println("Invalid choice ");

		}

	}

	public void generateReport() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Transaction> transactionList = new ArrayList<>();
		System.out.println("Enter date in yyyy-mm-dd");
		LocalDate date=null;	
		String fDate = sc.next();
		if (fDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			try{
			date = LocalDate.parse(fDate);
			}
			catch(Exception e)
			{
					System.out.println("Date Not Valid");
					return;
			}
			boolean status = stockManagerServiceImpl.generateReport(date);
			if (status) {
				System.out.println("Report generated!!!");
			} else
				System.out.println("No transactions available for the provided date!!");

		} else {
			System.out.println("Please enter date in the specified format!!");
		}
	}

}
