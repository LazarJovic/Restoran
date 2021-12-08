package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import baza.BazaPodatakaKonekcija;

public class SlikaJelaRepo {

	public boolean dodajSlikuJela(String putanja, int jeloId) {
		String dodajSlikuJela = "INSERT INTO Slika_Jela(putanja, jelo_id) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dodajSlikuJela);
			preparedStatement.setString(1,  putanja);
			preparedStatement.setInt(2,  jeloId);
			preparedStatement.execute();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
