package com.cafe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe.beans.Food;
import com.cafe.beans.Transaction;
import com.cafe.dao.TransactionDao;
import com.cafe.helper.ConnectionHelper;

public class TransactionDaoImpl implements TransactionDao{

	@Override
	public boolean insertTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("Insert into transaction" + "values(?,?,?,?)");

		statement.setString(1, transaction.getDate());
		statement.setString(2, transaction.getFood_id());
		statement.setInt(3, transaction.getQuantity());
		statement.setInt(4, transaction.getPrice());

		int rows = statement.executeUpdate();

		if (rows <= 0)
			return false;
		else
			return true;
	}

	

	@Override
	public ArrayList<Transaction> searchTransaction(String transaction_date) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement("Select * from transaction where transaction_date=?");
		statement.setString(0, transaction_date);
		Transaction transaction = null;
		ArrayList<Transaction> transactions=new ArrayList<>();
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			String foodId = rs.getString(2);
			int foodQuantity = rs.getInt(3);
			int totalPrice=rs.getInt(4);

			transaction = new Transaction(transaction_date,foodId,foodQuantity,totalPrice);
			transactions.add(transaction);
			
		}
		return transactions;
	}

}
