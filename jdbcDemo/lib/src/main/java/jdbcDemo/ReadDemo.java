package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step1: Load & register driver class
		Class.forName("org.postgresql.Driver");
		System.out.println("Registred driver class successfully");

		// step 2 : create connection to the db
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampledb", "postgres",
				"Maumita@123456");
		System.out.println("Created connection to the database successfully");

		// step3: create statement
		// Statement, PreparedStatement
		Statement stmt = con.createStatement();

		// step 4: execute query
		ResultSet rs = stmt.executeQuery("select * from employees");

		// step 5: process result
		// id | name | dept_id
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}

		// step 6: close the connections
		rs.close();
		stmt.close();
		con.close();

	}

}