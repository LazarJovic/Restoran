package kontroler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.ResultEmptyException;
import izuzeci.UniqueValueException;
import model.Korisnik;
import repozitorijum.KorisnikRepo;
import util.Validacija;

public class KorisnikKontroler {

	private Korisnik korisnik;
	private KorisnikRepo korisnikRepo;
	
	public KorisnikKontroler() {
		korisnikRepo = new KorisnikRepo();
	}
	
	public Korisnik dobaviKorisnikaPoKorImenu(String korisnickoIme) throws ResultEmptyException {
		Korisnik korisnik = korisnikRepo.dobaviKorisnikaPoKorImenu(korisnickoIme);
		if (korisnik == null) {
			throw new ResultEmptyException("Ne postoji korisnik sa korisničkim imenom " + korisnickoIme);
		}
		
		return korisnik;
	}
	
	public List<Korisnik> dobaviKorisnike() throws ResultEmptyException {
		List<Korisnik> korisnici = korisnikRepo.dobaviKorisnike();
		if (korisnici.size() == 0) {
			throw new ResultEmptyException("Nema registrovanih zaposlenih u restoranu.");
		}
		
		return korisnici;
	}
	
	public void izmeniKorisnika(String ime, String prezime, String telefon, String email, String stariEmail) throws MissingValueException, SQLException, BadFormatException, UniqueValueException {
		if (Validacija.praznaIliNepostojecaVrednost(ime)) {
			throw new MissingValueException("Nije validno uneto ime.");
		} else if (Validacija.praznaIliNepostojecaVrednost(prezime)) {
			throw new MissingValueException("Nije validno uneto prezime.");
		} else if (Validacija.praznaIliNepostojecaVrednost(telefon)) {
			throw new MissingValueException("Nije validno unet telefon.");
		} else if (!Validacija.validanTelefon(telefon)) {
			throw new BadFormatException("Broj telefona može da sadrži samo cifre 0-9.");
		} else if (Validacija.praznaIliNepostojecaVrednost(email)) {
			throw new MissingValueException("Nije validno uneta email adresa.");
		} else if (!Validacija.validanEmail(email)) {
			throw new BadFormatException("Email adresa nije uneta u validnom formatu. Mora biti oblika text@text.text");
		} else if (korisnikRepo.dobaviKorisnikaPoEmailAdresi(email) != null && !email.equals(stariEmail)) {
			throw new UniqueValueException("Uneta email adresa je već registrovana.");
		}
		
		try {
			korisnikRepo.izmeniKorisnika(ime, prezime, telefon, email, stariEmail);
		} catch (SQLException e) {
			throw new SQLException("Neuspešna izmena podataka korisnika.");
		}
				
		korisnik.azurirajKorisnika(ime, prezime, telefon, email);
	}
	
	public Korisnik registrujKorisnika(String ime, String prezime, String telefon, String email, String datumRodjenja,
			String korIme, String lozinka, String uloga) throws MissingValueException, BadFormatException, SQLException, UniqueValueException {
		if (Validacija.praznaIliNepostojecaVrednost(ime)) {
			throw new MissingValueException("Nije validno uneto ime.");
		} else if (Validacija.praznaIliNepostojecaVrednost(prezime)) {
			throw new MissingValueException("Nije validno uneto prezime.");
		} else if (Validacija.praznaIliNepostojecaVrednost(telefon)) {
			throw new MissingValueException("Nije validno unet telefon.");
		} else if (!Validacija.validanTelefon(telefon)) {
			throw new BadFormatException("Broj telefona može da sadrži samo cifre 0-9.");
		} else if (Validacija.praznaIliNepostojecaVrednost(email)) {
			throw new MissingValueException("Nije validno uneta email adresa.");
		} else if (!Validacija.validanEmail(email)) {
			throw new BadFormatException("Email adresa nije uneta u validnom formatu. Mora biti oblika text@text.text");
		} else if (korisnikRepo.dobaviKorisnikaPoEmailAdresi(email) != null) {
			throw new UniqueValueException("Uneta email adresa je već registrovana.");
		} else if (Validacija.praznaIliNepostojecaVrednost(datumRodjenja)) {
			throw new MissingValueException("Nije unet datum rodjenja.");
		} else if (Validacija.praznaIliNepostojecaVrednost(korIme)) {
			throw new MissingValueException("Nije uneto korisničko ime.");
		} else if (korisnikRepo.dobaviKorisnikaPoKorImenu(korIme) != null) {
			throw new UniqueValueException("Uneto korisničko ime je već registrovano.");
		} else if (Validacija.praznaIliNepostojecaVrednost(lozinka)) {
			throw new MissingValueException("Nije uneta lozinka.");
		} else if (!Validacija.validnaLozinka(lozinka)) {
			throw new BadFormatException("Lozinka mora da sadrži bar 8 karaktera, od čega bar jedno veliko slovo, malo slovo i broj.");
		} else if (Validacija.praznaIliNepostojecaVrednost(uloga)) {
			throw new MissingValueException("Nije odabrana uloga zaposlenog.");
		}
		
		LocalDate parsiranDatumRodjenja = null;
		try {
			parsiranDatumRodjenja = LocalDate.parse(datumRodjenja);	
		} catch (DateTimeParseException e) {
			throw new BadFormatException("Format datuma nije validan. Treba da bude oblika YYYY-MM-DD.");
		}
		
		if (uloga.equals("Šef kuhinje")) {
			uloga = "SEF_KUHINJE";
		} else if (uloga.equals("Menadžer")) {
			uloga = "MENADZER";
		}
		
		return korisnikRepo.dodajKorisnika(ime, prezime, telefon, email, parsiranDatumRodjenja, korIme, lozinka, uloga);
	}
	
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
}
