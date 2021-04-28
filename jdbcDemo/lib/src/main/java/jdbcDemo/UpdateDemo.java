package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step1: Load & register driver class
		Class.forName("org.postgresql.Driver");
		System.out.println("Registred driver class successfully");

		// step 2 : create connection to the db
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampledb", "postgres",
				"Maumita@123456");
		System.out.println("Created connection to the database successfully");

		// step3: create statement
		Statement stmt = con.createStatement();

		// 192 | Shiv | 202

		int result = stmt.executeUpdate("update employees set name='Shiva' where id=192");

		if (result == 1) {
			System.out.println("Successfully update employees");
		} else {
			System.out.println("Failed to update employees record");
		}

		stmt.close();
		con.close();

	}

}
