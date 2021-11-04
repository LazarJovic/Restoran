package pogled.meni;

public class MeniMenadzer extends Meni {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4213576067747275882L;
	private MeniStavka stavkaRezervacije;
	
	public MeniMenadzer() {
		super();
		
		stavkaRezervacije = new MeniStavka("/reservation1.png", "Rezervacije");
		add(stavkaRezervacije, "wrap, align center");
	}
	
	public MeniStavka getStavkaRezervacije() {
		return this.stavkaRezervacije;
	}
}
