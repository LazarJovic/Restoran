package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import baza.BazaPodatakaKonekcija;
import model.TipJela;

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
	
	public TipJela dobaviTipJelaPoNazivu(String naziv) {
		String dobaviTipJelaPoNazivu = "SELECT * FROM Tip_Jela WHERE naziv = ?";
		PreparedStatement preparedStatement = null;
		TipJela tipJela = null;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviTipJelaPoNazivu);
			preparedStatement.setString(1, naziv);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				tipJela = new TipJela(resultSet.getInt(1), resultSet.getString(2));
			}
		} catch (SQLException e) {
			return tipJela;
		}
		
		return tipJela;
	}
	
}
