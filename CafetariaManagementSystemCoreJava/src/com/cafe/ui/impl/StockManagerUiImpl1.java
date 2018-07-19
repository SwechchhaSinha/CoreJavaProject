package com.cafe.ui.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cafe.beans.Food;
import com.cafe.beans.Menu;
import com.cafe.service.impl.StockManagerServiceImpl;

public class StockManagerUiImpl1 {
	Scanner sc = new Scanner(System.in);
	StockManagerServiceImpl menuServiceImpl=new StockManagerServiceImpl();
	
	public void updateMenu() {
		boolean status=false;
		System.out.println("Enter the day for which you want to update menu");
		String day = sc.next();
		ArrayList<String> menuList = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			System.out.println("Enter dish " + i);
			menuList.add(sc.nextLine());
		}

		Menu menu = new Menu(menuList, day);
		try {
			 status=menuServiceImpl.updateMenu(menu);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(status==true)
			System.out.println("Menu Updated!!!");
		else 
			System.out.println("Couldn't update Menu!!");

	}
	public void outputStock()
	{
		//boolean status=false;
		List<Food> foodList = null;
		try {
			foodList = menuServiceImpl.displayFood();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		for (Food food : foodList) {
			System.out.println(food);
		}
		System.out.println("Enter food Id of the needed stock item");
		String fId=sc.next().toUpperCase();
		System.out.println("Enter the quantity");
		int quantity=sc.nextInt();
		try {
			int a=menuServiceImpl.outputStock(fId, quantity);
			if(a==1)
			{
				System.out.println("Please enter a valid quantity!!");
				outputStock();
			}
			else if(a==2)
			{
				System.out.println("You can take the food!!!");
			}
			else if(a==3)
			{
				System.out.println("There was some technical issue. Sorry, please try again later");
				outputStock();
			}
			else if(a==0)
			{
				System.out.println("Please enter a valid id");
				outputStock();
			}
			else
			{
				System.out.println("Sorry!! Insufficient stock. Verify again and then take!!");
				outputStock();
			}
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		
		
		
	}

}
