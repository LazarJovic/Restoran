package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import baza.BazaPodatakaKonekcija;
import enums.Uloga;
import model.KorisnickiNalog;

public class KorisnickiNalogRepo {
	
	public KorisnickiNalogRepo() {}
	
	public KorisnickiNalog dobaviNalogPoKorisnickomImenu(String korisnickoIme) {
		String dobaviNalogPoKorisnickomImenu = "SELECT * FROM Korisnicki_Nalog WHERE korisnicko_ime = ?";
		PreparedStatement preparedStatement = null;
		KorisnickiNalog korisnickiNalog = null;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviNalogPoKorisnickomImenu);
			preparedStatement.setString(1, korisnickoIme);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				korisnickiNalog = new KorisnickiNalog(resultSet.getString(2), resultSet.getString(3), getUloga(resultSet.getString(4)));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return korisnickiNalog;
	}

	private Uloga getUloga(String nazivUloge) {
		Uloga uloga;
		switch (nazivUloge) {
		case "VLASNIK":
			uloga = Uloga.VLASNIK;
			break;
		case "SEF_KUHINJE":
			uloga = Uloga.SEF_KUHINJE;
			break;
		case "MENADZER":
			uloga = Uloga.MENADZER;
			break;
		default:
			uloga = Uloga.KONOBAR;
			break;
		}
		
		return uloga;
	}
	
}
