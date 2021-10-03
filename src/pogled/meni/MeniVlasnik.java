package pogled.meni;

import javax.swing.JLabel;

public class MeniVlasnik extends Meni {

	private MeniStavka stavkaZaposleni;
	private MeniStavka stavkaZahteviZaJelo;
	private MeniStavka stavkaRezervacije;
	private MeniStavka stavkaInfoRestorana;
	
	public MeniVlasnik() {
		super();
		
		stavkaZaposleni = new MeniStavka("/employees1.png", "Zaposleni");
		stavkaZahteviZaJelo = new MeniStavka("/meal1.png", "Zahtevi za jelo");
		stavkaRezervacije = new MeniStavka("/reservation1.png", "Rezervacije");
		stavkaInfoRestorana = new MeniStavka("/info1.png", "Informacije o restoranu");
		
		add(stavkaZaposleni, "wrap, align center");
		add(stavkaZahteviZaJelo, "wrap, align center");
		add(stavkaRezervacije, "wrap, align center");
		add(stavkaInfoRestorana, "wrap, align center");
	}
	
	public MeniStavka getStavkaZaposleni() {
		return this.stavkaZaposleni;
	}
	
	public MeniStavka getStavkaZahteviZaJelo() {
		return this.stavkaZahteviZaJelo;
	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
	
	public MeniStavka getStavkaInforRestorana() {
		return this.stavkaInfoRestorana;
	}
	
}
