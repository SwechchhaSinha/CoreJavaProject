package com.cafe.service.impl;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
		boolean status2 = transactionDaoImpl
				.insertTransaction(new Transaction(date, food.getF_id(), food.getQuantity(), price));
		if (status1 == true && status2 == true)
			return true;
		return false;
	}

	@Override
	public boolean updateStock(String foodId, int quantity, int price, String date)
			throws ClassNotFoundException, SQLException {
		boolean status1 = foodDaoImpl.updateFoodQuantity(foodId,
				foodDaoImpl.searchFood(foodId).getQuantity() + quantity);
		boolean status2 = transactionDaoImpl.insertTransaction(new Transaction(date, foodId, quantity, price));
		if (status1 == true && status2 == true)
			return true;
		return false;

	}

	@Override
	public boolean outputStock(String foodId, int quantity) throws ClassNotFoundException, SQLException {
		boolean status1 = foodDaoImpl.updateFoodQuantity(foodId,
				foodDaoImpl.searchFood(foodId).getQuantity() - quantity);

		return status1;

	}
	@Override
	public boolean updateMenu(Menu menu) throws ClassNotFoundException, SQLException
	{
		return menuDaoImpl.updateMenu(menu);
			
	}
	@Override
	public void generateReport(String date) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Transaction> transactions=transactionDaoImpl.searchTransaction(date);
		File report=new File("Report_"+date);
		FileOutputStream fileOutputStream=new FileOutputStream(report);
		DataOutputStream stream=new DataOutputStream(fileOutputStream);
		for(Transaction t:transactions)
		{
			stream.writeChars(t.toString());
		}
				
	}

	@Override
	public void displayFood() throws ClassNotFoundException, SQLException {
		foodDaoImpl.listAllFood();
	}

	@Override
	public void displayFood(String category) throws ClassNotFoundException, SQLException {
		foodDaoImpl.listAllFood(category);

	}
}
