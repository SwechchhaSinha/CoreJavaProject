package com.cafe.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cafe.beans.Food;
import com.cafe.beans.Menu;

public interface StockManagerService {

	
	List<Food> displayFood() throws ClassNotFoundException, SQLException;

	List<Food> displayFood(String category) throws ClassNotFoundException, SQLException;

	boolean inputStock(Food food, int price, String date) throws ClassNotFoundException, SQLException;

	boolean updateStock(String foodId, int quantity, int price, String date)
			throws ClassNotFoundException, SQLException;

	String outputStock(String foodId, int quantity) throws ClassNotFoundException, SQLException;

	boolean updateMenu(Menu menu) throws ClassNotFoundException, SQLException;

	void generateReport(String date) throws ClassNotFoundException, SQLException, IOException;
}
