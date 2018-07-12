package com.cafe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.cafe.beans.Menu;
import com.cafe.dao.MenuDao;
import com.cafe.helper.ConnectionHelper;

public class MenuDaoImpl implements MenuDao
{

	@Override
	public boolean insertMenu(Menu menu) throws ClassNotFoundException, SQLException {
		Connection conn=ConnectionHelper.getConnection();
		ArrayList<String> addDishes=new ArrayList<>();
		PreparedStatement statement=conn.prepareStatement("Insert into Menu"
				+ "values(?,?,?,?,?,?,?,?,?)");
		
		statement.setString(1, menu.getMenuCurrentDay());
		addDishes=menu.getMenuArrayList();
		int j=2;
		for(int i=0;i<addDishes.size();i++)
		{
			statement.setString(j, addDishes.get(i));
			j++;
		}
		int rows=statement.executeUpdate();
		
		if(rows <= 0)
			return false;		
		else
			return true;
	}

	@Override
	public boolean updateMenu(Menu menu) throws ClassNotFoundException, SQLException
	{
		Connection conn=ConnectionHelper.getConnection();
		PreparedStatement statement=conn.prepareStatement("update Menu set dish_1=?,dish_2=?,"
				+ "dish_3=?,dish_4=?,dish_5=?,dish_6=?,dish_7=?,dish_8=? where menu_day=?");
		statement.setString(1, menu.getMenuCurrentDay());
		for(int i=0;i<menu.getMenuArrayList().size();i++)
		{
			statement.setString(i+2, menu.getMenuArrayList().get(i));
			i++;
		}
		int rows=statement.executeUpdate();
		if(rows <= 0)
			return false;		
		else
			return true;
	}

	@Override
	public Menu searchMenu(String day) throws ClassNotFoundException, SQLException {
		ArrayList<String> dishes=new ArrayList<>();
		Menu menu=new Menu();
		Connection conn=ConnectionHelper.getConnection();
		Statement statement=conn.createStatement();
		String searchedDay = null;
		ResultSet rs=statement.executeQuery("Select * from Menu where day="+"'"+day+"'");
		while(rs.next())
		{
			searchedDay=rs.getString(1);
			dishes.add(rs.getString(2));
			dishes.add(rs.getString(3));
			dishes.add(rs.getString(4));
			dishes.add(rs.getString(5));
			dishes.add(rs.getString(6));
			dishes.add(rs.getString(7));
			dishes.add(rs.getString(8));
			dishes.add(rs.getString(9));
		}
		menu.setMenuCurrentDay(searchedDay);
		menu.setMenuArrayList(dishes);
		return menu;
	}
	
}
