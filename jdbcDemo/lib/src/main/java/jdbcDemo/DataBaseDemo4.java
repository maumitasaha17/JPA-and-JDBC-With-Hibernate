package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseDemo4 {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/sampledb";
		String user = "user12";
		String password = "34klq*";

		int id = 6;
		String author = "Trygve Gulbranssen";
		String query = "INSERT INTO authors(id, name) VALUES(?, ?)";

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pst = con.prepareStatement(query)) {

			pst.setInt(1, id);
			pst.setString(2, author);
			pst.executeUpdate();

		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(JavaPostgreSqlPrepared.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
}