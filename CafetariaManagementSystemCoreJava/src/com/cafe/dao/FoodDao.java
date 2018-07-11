package com.cafe.dao;
import java.util.List;

import com.cafe.beans.Food;;
public interface FoodDao {
	List<Food> listAllFood();
	List<Food> listAllFood(String category);
	Food searchFood(String food_id);
	boolean insertFood(Food food);
	boolean updateFoodQuantity(int qty);
	boolean deleteFood(String food_id);

}
