package izuzeci;

public class ResultEmptyException extends Exception {
	
	private String naslov;
	
	public ResultEmptyException(String message) {
		super(message);
		this.naslov = "Rezultat je prazan";
	}
	
	public String getNaslov() {
		return this.naslov;
	}

}
