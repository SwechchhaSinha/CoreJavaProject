package com.cafe.dao;

import com.cafe.beans.Food;

public interface MenuDao 
{
	boolean insertFood(Food food);
	boolean updateFood(Food food);
	Food searchFood(String day);
	
	

}
