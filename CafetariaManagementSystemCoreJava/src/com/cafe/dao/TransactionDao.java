package com.cafe.dao;

import java.sql.SQLException;

import com.cafe.beans.Transaction;

public interface TransactionDao {
	boolean insertTransaction(Transaction transaction) throws ClassNotFoundException, SQLException;
	
	Transaction searchtransaction(String trasaction_id) throws ClassNotFoundException, SQLException;
}
