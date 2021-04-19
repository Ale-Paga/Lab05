package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	
	// check user e password
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=10roma10";

	static private HikariDataSource ds = null;
	
	public static Connection getConnection() {

		if(ds==null) {
			ds = new HikariDataSource();  //così si crea una nuova connessione solo la prima volta che chiamo getConnection
			
			ds.setJdbcUrl(jdbcUrl);
			//ds.setUsername("root");
			//ds.setPassword("10roma10");
		}
		
		try {
				Connection connection = ds.getConnection();
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}