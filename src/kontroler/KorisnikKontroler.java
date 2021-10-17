package kontroler;

import java.sql.SQLException;

import izuzeci.MissingValueException;
import model.Korisnik;
import repozitorijum.KorisnikRepo;

public class KorisnikKontroler {

	private Korisnik korisnik;
	private KorisnikRepo korisnikRepo;
	
	public KorisnikKontroler() {
		korisnikRepo = new KorisnikRepo();
	}
	
	public Korisnik dobaviKorisnikaPoKorImenu(String korisnickoIme) {
		return korisnikRepo.dobaviKorisnikaPoKorImenu(korisnickoIme);
	}
	
	public void izmeniKorisnika(String ime, String prezime, String telefon, String email, String stariEmail) throws MissingValueException, SQLException {
		//TODO: Validacija - mejl, telefon
		if (checkIfNullOrEmpty(ime)) {
			throw new MissingValueException("Nije validno uneto ime.");
		} else if (checkIfNullOrEmpty(prezime)) {
			throw new MissingValueException("Nije validno uneto prezime.");
		} else if (checkIfNullOrEmpty(telefon)) {
			throw new MissingValueException("Nije validno unet telefon.");
		} else if (checkIfNullOrEmpty(email)) {
			throw new MissingValueException("Nije validno uneta email adresa.");
		}
		
		try {
			korisnikRepo.izmeniKorisnika(ime, prezime, telefon, email, stariEmail);
		} catch (SQLException e) {
			throw new SQLException("Neuspešna izmena podataka korisnika.");
		}
				
		//TODO: Ovo u jednu metodu klase Korisnik (mozda)
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setTelefon(telefon);
		korisnik.setEmail(email);
		korisnik.notifyObservers();
	}
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
}
