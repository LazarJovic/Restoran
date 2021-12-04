package model;

public class Cena {

	private float vrednost;
	private float popust;
	
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
}
