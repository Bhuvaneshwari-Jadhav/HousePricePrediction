package org.housePredict.Config;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBConfig {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	protected CallableStatement csmt;

	public DBConfig() {
    try {
    	
//    	String driverClassName=PathHelper.p.getProperty("db.driverClass");
//    	String username=PathHelper.p.getProperty("db.username");
//    	String password=PathHelper.p.getProperty("db.password");
//    	String url=PathHelper.p.getProperty("db.url");
    	
//    	System.out.println("Driver class name : "+ driverClassName);
//    	System.out.println("databae username : " +username);
//    	System.out.println("database password : " +password);
//    	System.out.println("url name  : " +url);
    	
//    	System.out.println(mainPath);
    	Class.forName(PathHelper.p.getProperty("db.driverClass"));
    	conn=DriverManager.getConnection(PathHelper.p.getProperty("db.url"),
    			PathHelper.p.getProperty("db.username"),
    			PathHelper.p.getProperty("db.password"));
    	        System.out.println("databse connected");
    	
    }
    catch(Exception ex)
    {
    	System.out.println("Error is : "+ex);
    }
	}
	
	public static void main(String x[])
	{
		new DBConfig();
	}
}
