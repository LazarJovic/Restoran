package model;

public class Cenovnik {
	
	private Jelo jelo;
	private Cena cena;
	
	public Cenovnik() {}
	
	public Cenovnik(Jelo jelo, Cena cena) {
		this.jelo = jelo;
		this.cena = cena;
	}

	public Jelo getJelo() {
		return jelo;
	}

	public void setJelo(Jelo jelo) {
		this.jelo = jelo;
	}

	public Cena getCena() {
		return cena;
	}

	public void setCena(Cena cena) {
		this.cena = cena;
	}
	
	
}
