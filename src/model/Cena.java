package model;

import java.time.LocalDate;

public class Cena {

	private float vrednost;
	private float popust;
	private LocalDate kreirana;
	
	public Cena() {}
	
	public Cena(float vrednost, float popust) {
		this.vrednost = vrednost;
		this.popust = popust;
	}
	
	public float getVrednost() {
		return this.vrednost;
	}
	
	public void setVrednost(float vrednost) {
		this.vrednost = vrednost;
	}
	
	public float getPopust() {
		return this.popust;
	}
	
	public void setPopust(float popust) {
		this.popust = popust;
	}
	
	public float getCena() {
		return vrednost - vrednost*(popust/100);
	}
	
	public void setKreirana(LocalDate kreirana) {
		this.kreirana = kreirana;
	}
	
	public LocalDate getKreirana() {
		return this.kreirana;
	}
}
