package com.cafe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cafe.beans.Food;
import com.cafe.dao.FoodDao;
import com.cafe.helper.ConnectionHelper;

public class FoodDaoImpl implements FoodDao {

	@Override
	public List<Food> listAllFood() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		Statement statement = conn.createStatement();
		ArrayList<Food> foodList = new ArrayList<>();
		ResultSet rs = statement.executeQuery("Select * from food_item");
		while (rs.next()) {
			String foodId = rs.getString(1);
			String foodName = rs.getString(2);
			String category = rs.getString(3);
			int foodQuantity = rs.getInt(4);

			Food food = new Food(foodId, foodName, category, foodQuantity);
			foodList.add(food);
		}
		return foodList;

	}

	@Override
	public List<Food> listAllFood(String category) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("Select * from food_item where category=?");
		statement.setString(1, category);
		ArrayList<Food> foodList = new ArrayList<>();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			String foodId = rs.getString(1);
			String foodName = rs.getString(2);
			String cat = rs.getString(3);
			int foodQuantity = rs.getInt(4);

			Food food = new Food(foodId, foodName, cat, foodQuantity);
			foodList.add(food);
		}
		return foodList;
	}

	@Override
	public Food searchFood(String food_id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("Select * from food_item where food_id=?");
		statement.setString(1, food_id);
		Food food = new Food();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			String foodId = rs.getString(1);
			String foodName = rs.getString(2);
			String cat = rs.getString(3);
			int foodQuantity = rs.getInt(4);

			food = new Food(foodId, foodName, cat, foodQuantity);

		}
		return food;
	}

	@Override
	public boolean insertFood(Food food) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionHelper.getConnection();
		System.out.println(food);
		PreparedStatement statement = conn.prepareStatement("Insert into food_item values(?,?,?,?)");

		statement.setString(1, food.getF_id());
		statement.setString(2, food.getF_name());
		statement.setString(3, food.getCategory());
		statement.setInt(4, food.getQuantity());

		int rows = statement.executeUpdate();

		if (rows <= 0)
			return false;
		else
			return true;

	}

	@Override
	public boolean updateFoodQuantity(String food_id, int qty) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("update food_item set food_quantity=? where food_id=?");

		statement.setString(2, food_id);
		statement.setInt(1, qty);
		int rows = statement.executeUpdate();

		if (rows <= 0)
			return false;
		else
			return true;

	}

	@Override
	public boolean deleteFood(String food_id) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		//PreparedStatement statement1 = conn.prepareStatement("delete from transaction where food_id=?");
		PreparedStatement statement = conn.prepareStatement("delete from food_item where food_id=? ");
		//statement1.setString(1, food_id);
		statement.setString(1, food_id);

		int rows = statement.executeUpdate();

		if (rows <= 0)
			return false;
		else
			return true;
	}

}
