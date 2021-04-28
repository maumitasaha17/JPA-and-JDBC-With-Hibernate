package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsetDemo {

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
		String sql = "insert into employees(id, name, dept_id) values(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter emp id: ");
			ps.setInt(1, sc.nextInt());

			System.out.println("Enter emp name: ");
			ps.setString(2, sc.next());

			System.out.println("Enter emp dept id: ");
			ps.setInt(3, sc.nextInt());

			ps.executeUpdate();

			System.out.println("Enter 'y' to continue or 'n' to exit");
			if (sc.next().startsWith("n")) {
				sc.close();
				break;
			}

		} while (true);

		// step 4: execute query
		// ResultSet rs = stmt.executeQuery("select * from employees");

		// step 5: process result
		// id | name | dept_id
		// while (rs.next()) {
		// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
		// rs.getInt(3));
		// }

		// step 6: close
		ps.close();
		con.close();

	}

}