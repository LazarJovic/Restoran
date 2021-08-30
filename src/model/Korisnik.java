package model;

import java.time.LocalDate;

public class Korisnik {
	
	private String ime;
	private String prezime;
	private String telefon;
	private String email;
	private LocalDate datumRodjenja;
	private LocalDate datumZaposlenja;
	private KorisnickiNalog korisnickiNalog;
	
	public Korisnik() {}

	public Korisnik(String ime, String prezime, String telefon, String email, LocalDate datumRodjenja,
			LocalDate datumZaposlenja, KorisnickiNalog korisnickiNalog) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.datumRodjenja = datumRodjenja;
		this.datumZaposlenja = datumZaposlenja;
		this.korisnickiNalog = korisnickiNalog;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public LocalDate getDatumZaposlenja() {
		return datumZaposlenja;
	}

	public void setDatumZaposlenja(LocalDate datumZaposlenja) {
		this.datumZaposlenja = datumZaposlenja;
	}

	public KorisnickiNalog getKorisnickiNalog() {
		return korisnickiNalog;
	}

	public void setKorisnickiNalog(KorisnickiNalog korisnickiNalog) {
		this.korisnickiNalog = korisnickiNalog;
	}
}
