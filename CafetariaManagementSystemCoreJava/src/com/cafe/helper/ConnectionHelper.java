package com.cafe.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper 
{
	private static Connection connection;
	private static ConnectionHelper connectionHelper;
	private ConnectionHelper() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		connection=DriverManager.getConnection("jdbc:postgresql://12"
				+ "7.0.0.1:5432/CMS","postgres","admin");		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(connectionHelper==null|| connection.isClosed())
			connectionHelper=new ConnectionHelper();
		return connection;
	}
}
