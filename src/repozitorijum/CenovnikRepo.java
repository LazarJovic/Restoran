package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import baza.BazaPodatakaKonekcija;

public class CenovnikRepo {

	public boolean dodajCenuJelo(int jeloId, int cenaId) {
		String dodajCenovnik = "INSERT INTO Cenovnik (jelo_id, cena_id) VALUES(?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dodajCenovnik);
			preparedStatement.setInt(1,  jeloId);
			preparedStatement.setInt(2,  cenaId);
			preparedStatement.execute();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
}
