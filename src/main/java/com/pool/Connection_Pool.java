package com.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connection_Pool {
	static int pool_size=7;
	static List<Connection> con = new ArrayList<>(pool_size);
	static String path="org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost:5432/yourDB";
	static String user = "postgres";
	static String pwd="yourPassword";

	static {
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<pool_size;i++) {
			Connection conn = createConnection();
			con.add(conn);
		}
	}
	
	public static Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection() {
		if(!con.isEmpty()) {
			return con.remove(0);
		}
		return createConnection();
	}
	
	public static void receive(Connection conn) {
		if(con.size()<pool_size) {
			con.add(conn);
		}
		else {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
