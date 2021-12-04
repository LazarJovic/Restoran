package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import baza.BazaPodatakaKonekcija;

public class TipJelaRepo {

	public TipJelaRepo() {}
	
	public String[] dobaviNaziveTipovaJela() {
		String dobaviTipoveJela = "SELECT * FROM Tip_Jela";
		PreparedStatement preparedStatement = null;
		ArrayList<String> nazivi = new ArrayList<String>();
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviTipoveJela);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				nazivi.add(resultSet.getString(2));
			}
		} catch (SQLException e) {
			return null;
		}
		
		String[] naziviTipovaJela = new String[nazivi.size()];
		return nazivi.toArray(naziviTipovaJela);
	}
	
}
