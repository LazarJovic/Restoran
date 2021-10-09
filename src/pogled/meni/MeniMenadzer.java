package pogled.meni;

import javax.swing.JLabel;

public class MeniMenadzer extends Meni {

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
