package kontroler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.ResultEmptyException;
import model.Korisnik;
import pogled.PogledUtil;
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
	
	public List<Korisnik> dobaviKorisnike() throws ResultEmptyException {
		List<Korisnik> korisnici = korisnikRepo.dobaviKorisnike();
		if (korisnici.size() == 0) {
			throw new ResultEmptyException("Nema registrovanih zaposlenih u restoranu.");
		}
		
		return korisnici;
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
	
	public Korisnik registrujKorisnika(String ime, String prezime, String telefon, String email, String datumRodjenja,
			String korIme, String lozinka, String uloga) throws MissingValueException, BadFormatException, SQLException {
		if (checkIfNullOrEmpty(ime)) {
			throw new MissingValueException("Nije validno uneto ime.");
		} else if (checkIfNullOrEmpty(prezime)) {
			throw new MissingValueException("Nije validno uneto prezime.");
		} else if (checkIfNullOrEmpty(telefon)) {
			throw new MissingValueException("Nije validno unet telefon.");
		} else if (checkIfNullOrEmpty(email)) {
			throw new MissingValueException("Nije validno uneta email adresa.");
		} else if (checkIfNullOrEmpty(datumRodjenja)) {
			throw new MissingValueException("Nije unet datum rodjenja.");
		} else if (checkIfNullOrEmpty(korIme)) {
			throw new MissingValueException("Nije uneto korisničko ime.");
		} else if (checkIfNullOrEmpty(lozinka)) {
			throw new MissingValueException("Nije uneta lozinka.");
		} else if (checkIfNullOrEmpty(uloga)) {
			throw new MissingValueException("Nije odabrana uloga zaposlenog.");
		}
		
		//TODO: Validacija - email, telefon, lozinka
		
		LocalDate parsiranDatumRodjenja = null;
		try {
			parsiranDatumRodjenja = LocalDate.parse(datumRodjenja);	
		} catch (DateTimeParseException e) {
			throw new BadFormatException("Format datuma nije validan. Treba da bude oblika DD.MM.YYYY.");
		}
		
		return korisnikRepo.dodajKorisnika(ime, prezime, telefon, email, parsiranDatumRodjenja, korIme, lozinka, uloga);
	}
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
}
