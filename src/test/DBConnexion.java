package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnexion {

	private static String userName = "root";
	private static String password = "root";
	private static String serverName = "localhost";
	private static String portNumber = "8889";
	private static String dbName = "projettut";

	private static Connection connexion;

	private DBConnexion() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		String urlDB = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		connexion = DriverManager.getConnection(urlDB, userName, password);
	}

	public synchronized static Connection getConnexion() throws SQLException {
		if (connexion == null)
			new DBConnexion();
		return connexion;
	}

	public static void setDbName(String p_dbName) throws SQLException {
		connexion = null;
		dbName = p_dbName;
	}

}