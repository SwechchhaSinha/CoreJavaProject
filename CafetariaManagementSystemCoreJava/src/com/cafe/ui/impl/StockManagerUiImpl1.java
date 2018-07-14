package com.cafe.ui.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
		boolean status=false;
		System.out.println("Enter food Id of the needed stock item");
		String fId=sc.next();
		System.out.println("Enter the quantity");
		int quantity=sc.nextInt();
		try {
			System.out.println(menuServiceImpl.outputStock(fId, quantity));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
