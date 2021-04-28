package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// step1: Load & register driver class
		Class.forName("org.postgresql.Driver");
		System.out.println("Registred driver class successfully");

		// step 2 : create connection to the db
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampledb", "postgres",
				"Maumita@123456");
		System.out.println("Created connection to the database successfully");

		// step3: create statement
		// 104 | Raghu | 202
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate("delete from employee where id=190");
		if (result == 1) {
			System.out.println("Successfully deleted employees");
		} else {
			System.out.println("Failed to delete employees record");
		}

		stmt.close();
		con.close();

	}

}