package baza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BazaPodatakaKonekcija {
	
	private final String bazaInfo = "src/resources/baza.properties";
	
	private static BazaPodatakaKonekcija instance = null;
	
	private Connection konekcija;
	
	private BazaPodatakaKonekcija() {
		Properties props = new Properties();
		try(FileInputStream in = new FileInputStream(bazaInfo)) {
			props.load(in);
			napraviKonekciju(props.getProperty("baza.driver"), props.getProperty("baza.url"), props.getProperty("baza.user"), props.getProperty("baza.pass"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BazaPodatakaKonekcija getInstance() {
		if (instance == null) {
			instance = new BazaPodatakaKonekcija();
		}
		
		return instance;
	}
	
	private void napraviKonekciju(String driver, String url, String username, String password) {
		try {
			Class.forName(driver); // load the driver
			try {
				konekcija = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}
	
	public Connection getKonekcija() {
		return this.konekcija;
	}

}
