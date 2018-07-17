package com.cafe.service.impl;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cafe.beans.Food;
import com.cafe.beans.Menu;
import com.cafe.beans.Transaction;
import com.cafe.service.StockManagerService;

import com.cafe.dao.impl.FoodDaoImpl;
import com.cafe.dao.impl.MenuDaoImpl;
import com.cafe.dao.impl.TransactionDaoImpl;

public class StockManagerServiceImpl implements StockManagerService {
	FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
	TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
	MenuDaoImpl menuDaoImpl=new MenuDaoImpl();

	@Override
	public boolean inputStock(Food food, int price, String date) throws ClassNotFoundException, SQLException {
		boolean status1 = foodDaoImpl.insertFood(food);
		LocalDate date1=LocalDate.parse(date);//Change
		Transaction t=new Transaction(date1, food.getF_id(), food.getQuantity(), price);
		System.out.println(t);
		boolean status2 = transactionDaoImpl.insertTransaction(t);
		if (status1 == true && status2 == true)
			return true;
		return false;
	}

	@Override
	public boolean updateStock(String foodId, int quantity, int price, LocalDate date1)
			throws ClassNotFoundException, SQLException {
		boolean status1 = foodDaoImpl.updateFoodQuantity(foodId,
				foodDaoImpl.searchFood(foodId).getQuantity() + quantity);
		Date date=Date.valueOf(date1);
		
		boolean status2 = transactionDaoImpl.insertTransaction(new Transaction(date1, foodId, quantity, price));
		if (status1 == true && status2 == true)
			return true;
		return false;

	}

	@Override
	public String outputStock(String foodId, int quantity) throws ClassNotFoundException, SQLException
	{
		int currentQuantity=foodDaoImpl.searchFood(foodId).getQuantity();
		if(quantity<=currentQuantity)
		{
			boolean status1 = foodDaoImpl.updateFoodQuantity(foodId,currentQuantity-quantity);
			
//		if(foodDaoImpl.searchFood(foodId).getQuantity()<=foodDaoImpl.searchFood(foodId).getThreshold())
//		{
//			return "Food remaining is less than threhsold please refill it";
//		}
		return "You can take the food item";
		}
		

		else
			return "Sufficient stock not present!!";
	}
	@Override
	public boolean updateMenu(Menu menu) throws ClassNotFoundException, SQLException
	{
		return menuDaoImpl.updateMenu(menu);
			
	}
	@Override
	public void generateReport(LocalDate date) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Transaction> transactions=transactionDaoImpl.searchTransaction(date);
		
		File report=new File("Report_"+date);
		FileOutputStream fileOutputStream=new FileOutputStream(report);
		DataOutputStream stream=new DataOutputStream(fileOutputStream);
		for(Transaction t:transactions)
		{
			System.out.println(t);
			stream.writeChars(t.toString());
		}
				
	}

	@Override
	public List<Food> displayFood() throws ClassNotFoundException, SQLException {
		return(foodDaoImpl.listAllFood());
	}

	@Override
	public List<Food> displayFood(String category) throws ClassNotFoundException, SQLException {
		return foodDaoImpl.listAllFood(category);

	}

	@Override
	public boolean deleteStock(String foodId) throws ClassNotFoundException, SQLException {
		
		return foodDaoImpl.deleteFood(foodId);
	}
}
