package com.suntorycodetime.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	//Test Connection
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass ="hbstudent";
		
		try {
			System.out.println("Coneccting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection success");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
