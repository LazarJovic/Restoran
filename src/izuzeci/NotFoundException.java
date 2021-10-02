package izuzeci;

public class NotFoundException extends Exception {
	
	private String naslov;
	
	public NotFoundException(String message) {
		super(message);
		this.naslov = "Nepostojeća vrednost";
	}
	
	public String getNaslov() {
		return this.naslov;
	}
}
