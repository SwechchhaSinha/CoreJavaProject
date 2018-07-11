package com.cafe.dao;

import com.cafe.beans.Transaction;

public interface TransactionDao {
	boolean insertTransaction(Transaction transaction);
	boolean updateTransaction(String trasaction_id);
	Transaction searchtransaction(String trasaction_id);
}
