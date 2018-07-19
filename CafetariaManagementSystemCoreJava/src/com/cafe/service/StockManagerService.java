package com.cafe.service;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cafe.beans.Food;
import com.cafe.beans.Menu;
import com.cafe.beans.Transaction;

public interface StockManagerService {

	
	List<Food> displayFood() throws ClassNotFoundException, SQLException;

	List<Food> displayFood(String category) throws ClassNotFoundException, SQLException;

	boolean inputStock(Food food, int price, LocalDate date) throws ClassNotFoundException, SQLException;

	//boolean updateStock(String foodId, int quantity, int price, String date)
//			throws ClassNotFoundException, SQLException;

	int outputStock(String foodId, int quantity) throws ClassNotFoundException, SQLException;

	boolean updateMenu(Menu menu) throws ClassNotFoundException, SQLException;

	//void generateReport(String date) throws ClassNotFoundException, SQLException, IOException;
	boolean deleteStock(String foodId) throws ClassNotFoundException, SQLException;

	boolean updateStock(String foodId, int quantity, int price, LocalDate date1)
			throws ClassNotFoundException, SQLException;


	boolean generateReport(LocalDate date) throws ClassNotFoundException, SQLException, IOException;

}
