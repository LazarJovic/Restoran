package izuzeci;

public class MissingValueException extends Exception {
	
	private String naslov;
	
	public MissingValueException(String poruka) {
		super(poruka);
		naslov  = "Nedostajuća vrednost";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}
