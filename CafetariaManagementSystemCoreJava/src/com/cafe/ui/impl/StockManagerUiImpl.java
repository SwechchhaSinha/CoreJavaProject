package com.cafe.ui.impl;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.cafe.beans.Food;
import com.cafe.service.impl.StockManagerServiceImpl;
import com.cafe.ui.StockManagerUi;

public class StockManagerUiImpl implements StockManagerUi {
	Scanner sc = new Scanner(System.in);
	StockManagerServiceImpl stockManagerServiceImpl = new StockManagerServiceImpl();
	@Override
	public void displayStock() throws ClassNotFoundException, SQLException {
		
		System.out.println("1. All \n 2. Categorywise");
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			List<Food> foodList=stockManagerServiceImpl.displayFood();
			for(Food food:foodList)
			{
				System.out.println(food);
			}
			break;
		case 2:
			System.out.println("Enter categroy: ");
			String category = sc.next();
			List<Food> foodList1=stockManagerServiceImpl.displayFood(category);
			for(Food food:foodList1)
			{
				System.out.println(food);
			}
			break;
		default:
			System.out.println("Please enter the right choice.");
		}
		
	}
	public void updateStock(){
		System.out.println("1. Insert new stock"
				+ "2. Update Existing stock"
				+ "3. Delete Existing stock");
		int choice = sc.nextInt();
		boolean status = false;
		switch(choice){
			case 1:
				System.out.println("Enter Food_Id");
				String fId = sc.next();
				System.out.println("Enter food name");
				String fName  = sc.next();
				System.out.println("Enter food category");
				String fCategory = sc.next();
				System.out.println("Enter food quantity");
				int fQty = sc.nextInt();
				Food food = new Food(fId, fName, fCategory, fQty);
				System.out.println("Enter price: ");
				int fPrice = sc.nextInt();
				System.out.println("Enter date in yyyy-mm-dd");
				String fDate = sc.next();
			try {
				status = stockManagerServiceImpl.inputStock(food, fPrice, fDate);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				if(status)
					System.out.println("Stock inserted successfully");
				else
					System.out.println("Stock not inserted; Check your details again");
				break;				
			case 2:
				System.out.println("Enter Food_Id");
				fId = sc.next();
				System.out.println("Enter food quantity");
				fQty = sc.nextInt();
				System.out.println("Enter price: ");
				fPrice = sc.nextInt();
				System.out.println("Enter date in yyyy-mm-dd");
				fDate = sc.next();
				LocalDate date=LocalDate.parse(fDate);
			try {
				
				status = stockManagerServiceImpl.updateStock(fId, fQty, fPrice, date);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(status)
					System.out.println("Stock updated successfully");
				else
					System.out.println("Stock not updated; Check your details again.");
				break;
			case 3:
				System.out.println("Enter Food_Id");
				fId = sc.next();
			try {
				status = stockManagerServiceImpl.deleteStock(fId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(status)
					System.out.println("Stock deleted successfully");
				else
					System.out.println("Stock not deleted; Check your Food_Id again");
				break;
			default:
				System.out.println("Invalid choice ");
				
		}
		
	}
	public void generateReport() throws ClassNotFoundException, SQLException, IOException{
		System.out.println("Enter date in yyyy-mm-dd");
		String fDate = sc.next();
		if (fDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			LocalDate date=LocalDate.parse(fDate);
		boolean status=stockManagerServiceImpl.generateReport(date);
		if(status)
		{
			System.out.println("Report generated!!!");
		}
		else
			System.out.println("No transactions available for the provided date!!");
		}
		else
		{
			System.out.println("Please enter date in the specified format!!");
		}
	}

}
