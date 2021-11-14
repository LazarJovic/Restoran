package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import baza.BazaPodatakaKonekcija;
import enums.Uloga;
import model.KorisnickiNalog;
import model.Korisnik;

public class KorisnikRepo {

	private KorisnickiNalogRepo korisnickiNalogRepo;
	
	public KorisnikRepo() {
		this.korisnickiNalogRepo = new KorisnickiNalogRepo();
	}
	
	public List<Korisnik> dobaviKorisnike() {
		String dobaviKorisnike = 
				"SELECT * FROM Korisnik korisnik JOIN Korisnicki_Nalog nalog ON korisnik.id = nalog.id";
		PreparedStatement preparedStatement = null;
		List<Korisnik> korisnici = new ArrayList<>();
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviKorisnike);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				korisnici.add(new Korisnik(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						LocalDate.parse(resultSet.getString(6)), LocalDate.parse(resultSet.getString(7)),
						new KorisnickiNalog(resultSet.getString(10), resultSet.getString(11), getUloga(resultSet.getString(12)))));
			}
		} catch (SQLException e) {
			return korisnici;
		}
		
		return korisnici;
	}
	
	public Korisnik dobaviKorisnikaPoKorImenu(String korisnickoIme) {
		String dobaviKorisnikaPoKorImenu =
				"SELECT * FROM Korisnik korisnik JOIN Korisnicki_Nalog nalog ON korisnik.id = nalog.id WHERE nalog.korisnicko_ime = ?";
		PreparedStatement preparedStatement = null;
		Korisnik korisnik = null;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviKorisnikaPoKorImenu);
			preparedStatement.setString(1, korisnickoIme);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				korisnik = new Korisnik(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						LocalDate.parse(resultSet.getString(6)), LocalDate.parse(resultSet.getString(7)),
						new KorisnickiNalog(resultSet.getString(10), resultSet.getString(11), getUloga(resultSet.getString(12))));
			}
		} catch (SQLException e) {
			return korisnik;
		}
		
		return korisnik;
	}
	
	public Korisnik dobaviKorisnikaPoEmailAdresi(String email) {
		String dobaviKorisnikaPoKorImenu =
				"SELECT * FROM Korisnik korisnik JOIN Korisnicki_Nalog nalog ON korisnik.id = nalog.id WHERE korisnik.email = ?";
		PreparedStatement preparedStatement = null;
		Korisnik korisnik = null;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviKorisnikaPoKorImenu);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				korisnik = new Korisnik(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						LocalDate.parse(resultSet.getString(6)), LocalDate.parse(resultSet.getString(7)),
						new KorisnickiNalog(resultSet.getString(10), resultSet.getString(11), getUloga(resultSet.getString(12))));
			}
		} catch (SQLException e) {
			return korisnik;
		}
		
		return korisnik;
	}
	
	public void izmeniKorisnika(String ime, String prezime, String telefon, String email, String oldEmail) throws SQLException {
		String izmeniKorisnika =
				"UPDATE Korisnik SET ime = ?, prezime = ?, telefon = ?, email = ? WHERE email = ?";
		PreparedStatement preparedStatement = null;
		preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(izmeniKorisnika);
		preparedStatement.setString(1, ime);
		preparedStatement.setString(2, prezime);
		preparedStatement.setString(3, telefon);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, oldEmail);
		preparedStatement.executeUpdate();
	}
	
	public Korisnik dodajKorisnika(String ime, String prezime, String telefon, String email, LocalDate datumRodjenja,
			String korIme, String lozinka, String uloga) throws SQLException {
		long nalogId = korisnickiNalogRepo.dodajKorisnickiNalog(korIme, lozinka, uloga);
		LocalDate datumZaposlenja = LocalDate.now();
		String dodajKorsnika = 
				"INSERT INTO Korisnik (ime, prezime, telefon, email, datum_rodjenja, datume_zaposlenja, nalog_id)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dodajKorsnika, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, ime);
		preparedStatement.setString(2, prezime);
		preparedStatement.setString(3, telefon);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, datumRodjenja.toString());
		preparedStatement.setString(6, datumZaposlenja.toString());
		preparedStatement.setLong(7, nalogId);
		preparedStatement.execute();
		if (preparedStatement.getUpdateCount() <= 0) {
			return null;
		}
		
		return new Korisnik(ime, prezime, telefon, email, datumRodjenja, datumZaposlenja,
				new KorisnickiNalog(korIme, lozinka, getUloga(uloga.toUpperCase())));
	}
	
	private Uloga getUloga(String uloga) {
		switch (uloga) {
		case "VLASNIK":
			return Uloga.VLASNIK;
		case "SEF_KUHINJE":
			return Uloga.SEF_KUHINJE;
		case "MENADZER":
			return Uloga.MENADZER;
		default:
			return Uloga.KONOBAR;
		}
	}
	
}
