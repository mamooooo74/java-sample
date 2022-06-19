package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConector {
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "";
		Connection con = DriverManager.getConnection(sql, user, password);
		return con;
		
	}
}
