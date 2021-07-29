package loginFrame;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLConction {

	static Connection con;

	public static Connection databaseConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = (Connection) DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578", "S1706578",
				"lgvoe");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}