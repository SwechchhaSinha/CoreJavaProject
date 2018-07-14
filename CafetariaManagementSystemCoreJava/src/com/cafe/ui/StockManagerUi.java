package com.cafe.ui;

import java.io.IOException;
import java.sql.SQLException;

public interface StockManagerUi {
	void displayStock()throws ClassNotFoundException, SQLException;
	void updateStock() throws ClassNotFoundException, SQLException;
	void generateReport() throws ClassNotFoundException, SQLException, IOException;
	

}
