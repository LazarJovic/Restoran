package izuzeci;

public class BadCredentialsException extends Exception {
	
	private String naslov;
	
	public BadCredentialsException(String message) {
		super(message);
		naslov = "Loši kredencijali";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}
