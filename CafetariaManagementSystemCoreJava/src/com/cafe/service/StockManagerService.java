package com.cafe.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cafe.beans.Food;
import com.cafe.beans.Menu;

public interface StockManagerService {

	
	void displayFood() throws ClassNotFoundException, SQLException;

	void displayFood(String category) throws ClassNotFoundException, SQLException;

	boolean inputStock(Food food, int price, String date) throws ClassNotFoundException, SQLException;

	boolean updateStock(String foodId, int quantity, int price, String date)
			throws ClassNotFoundException, SQLException;

	boolean outputStock(String foodId, int quantity) throws ClassNotFoundException, SQLException;

	boolean updateMenu(Menu menu) throws ClassNotFoundException, SQLException;

	void generateReport(String date) throws ClassNotFoundException, SQLException, IOException;
}
