package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import baza.BazaPodatakaKonekcija;

public class CenaRepo {

	public int dodajCenu(float vrednost) {
		String dodajCenu = "INSERT INTO Cena(vrednost, popust, kreirana) VALUES(?, ?, ?)";
		PreparedStatement preparedStatement = null;
		int cenaId = 0;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija()
					.prepareStatement(dodajCenu, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setFloat(1, vrednost);
			preparedStatement.setFloat(2, 0);
			preparedStatement.setString(3, LocalDate.now().toString());
			preparedStatement.execute();
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
			      if (generatedKeys.next()) {
			    	  cenaId = generatedKeys.getInt(1);
			      }
			}
		} catch (SQLException e) {
			return cenaId;
		}
		return cenaId;
	}
	
}
