package kontroler;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import izuzeci.NotFoundException;
import model.KorisnickiNalog;
import model.PrijavljenKorisnik;
import repozitorijum.KorisnickiNalogRepo;

public class AuthKontroler {

	private KorisnickiNalogRepo korisnickiNalogRepo;
	
	public AuthKontroler() {
		this.korisnickiNalogRepo = new KorisnickiNalogRepo();
	}
	
	public boolean login(String korisnickoIme, String lozinka) throws MissingValueException, BadCredentialsException {
		if (checkIfNullOrEmpty(korisnickoIme)) {
			throw new MissingValueException("Nije validno uneto korisničko ime.");
		} else if (checkIfNullOrEmpty(lozinka)) {
			throw new MissingValueException("Nije validno uneta lozinka.");
		}
		
		KorisnickiNalog korisnickiNalog = korisnickiNalogRepo.dobaviNalogPoKorisnickomImenu(korisnickoIme);
		
		if (korisnickiNalog == null || !korisnickiNalog.getLozinka().equals(lozinka)) {
			throw new BadCredentialsException("Uneseni kredencijali nisu poklapajući.");
		}
		
		PrijavljenKorisnik prijavljenKorisnik = PrijavljenKorisnik.getInstance();
		prijavljenKorisnik.setKorisnickoIme(korisnickoIme);
		prijavljenKorisnik.setUloga(korisnickiNalog.getUloga());
		
		return true;
	}
	
	private boolean checkIfNullOrEmpty(String input) {
		return input == null || input.equals("");
	}
	
}
