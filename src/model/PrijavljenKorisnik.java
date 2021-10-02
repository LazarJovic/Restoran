package model;

import baza.BazaPodatakaKonekcija;
import enums.Uloga;

public class PrijavljenKorisnik {

	private static PrijavljenKorisnik instance = null;
	
	private String korisnickoIme;
	private Uloga uloga;
	
	private PrijavljenKorisnik() {}
	
	public static PrijavljenKorisnik getInstance() {
		if (instance != null) {
			return instance;
		}
		
		return new PrijavljenKorisnik();
	}
	
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}
	
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	
	public Uloga getUloga() {
		return this.uloga;
	}
}
