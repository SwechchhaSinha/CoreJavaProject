package com.cafe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe.beans.AddOn;
import com.cafe.dao.AddOnDao;
import com.cafe.helper.ConnectionHelper;

public class AddOnDaoImpl implements AddOnDao{

	@Override
	public List<AddOn> listAllAddOn() throws ClassNotFoundException, SQLException {
		Connection conn=ConnectionHelper.getConnection();
		Statement statement=conn.createStatement();
		ArrayList<AddOn> addOnList=new ArrayList<>();
		ResultSet rs=statement.executeQuery("Select * from AddOn");
		while(rs.next())
		{
			String addOnId=rs.getString(1);
			String addOnName=rs.getString(2);
			int addOnPrice=rs.getInt(3);
			int addOnQuantity=rs.getInt(4);
			String addOnCategory=rs.getString(5);
			AddOn addon = new AddOn(addOnId, addOnName, addOnPrice,addOnQuantity,addOnCategory);
			addOnList.add(addon);
		}
		return addOnList;
	}

	@Override
	public List<AddOn> listAllAddOn(String addOnCategory) throws ClassNotFoundException, SQLException {
		Connection conn=ConnectionHelper.getConnection();
		PreparedStatement pstatement=conn.prepareStatement("Select * from AddOn where category = ?");
		pstatement.setString(0, addOnCategory);
		ArrayList<AddOn> addOnList=new ArrayList<>();
		AddOn addon = null;
		ResultSet rs=pstatement.executeQuery();
		while(rs.next())
		{
			String addOnId=rs.getString(1);
			String addOnName=rs.getString(2);
			int addOnPrice=rs.getInt(3);
			int addOnQuantity=rs.getInt(4);
			
			 addon = new AddOn(addOnId, addOnName, addOnPrice,addOnQuantity,addOnCategory);
			addOnList.add(addon);
		}
		return addOnList;
	}

	@Override
	public boolean update(String addOnId, int addOnPrice, int addOnQuantity) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement pstatement = conn.prepareStatement("Update AddOn set addOnPrice = ?, addOnQuantity = ? where addOnId= ?");
		pstatement.setInt(1, addOnPrice);
		pstatement.setInt(2, addOnQuantity);
		pstatement.setString(3, addOnId);
		int rows = pstatement.executeUpdate();
		
		if(rows <= 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean insertAddOn(AddOn addon) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("Insert into addOn" + "values(?,?,?,?,?)");

		statement.setString(1, addon.getAddOnId());
		statement.setString(2, addon.getAddOnName());
		statement.setInt(3,addon.getAddOnPrice() );
		statement.setInt(4,addon.getAddOnQuantity() );
		statement.setString(5, addon.getAddOnCategory());

		int rows = statement.executeUpdate();

		if (rows <= 0)
			return false;
		else
			return true;
	}

	@Override
	public AddOn searchAddOn(String addOnId) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("Select * from addOn where addOnId_id=?");
		statement.setString(1, addOnId);
		AddOn addon = null;
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			String addOnId1=rs.getString(1);
			String addOnName=rs.getString(2);
			int addOnPrice=rs.getInt(3);
			int addOnQuantity=rs.getInt(4);
			String addOnCategory=rs.getString(5);

			addon = new AddOn(addOnId, addOnName, addOnPrice,addOnQuantity,addOnCategory);

		}
		return addon;
	}

	@Override
	public boolean deleteAddOn(String addOnId)throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("delete from addOn where addOnId_id=?");

		statement.setString(1, addOnId);

		int rows = statement.executeUpdate();

		if (rows <= 0)
			return false;
		else
			return true;
	}

}