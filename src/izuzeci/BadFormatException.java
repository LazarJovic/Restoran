package izuzeci;

public class BadFormatException extends Exception {
	
	private String naslov;
	
	public BadFormatException(String message) {
		super(message);
		naslov = "Loš format";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}
