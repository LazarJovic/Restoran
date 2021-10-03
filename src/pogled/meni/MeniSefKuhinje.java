package pogled.meni;

import javax.swing.JLabel;

public class MeniSefKuhinje extends Meni {

	private MeniStavka stavkaTipoviJela;
	private MeniStavka stavkaZahteviZaJelo;
	
	public MeniSefKuhinje() {
		super();
		
		stavkaTipoviJela = new MeniStavka("/mealType1.png", "Tipovi jela");
		stavkaZahteviZaJelo = new MeniStavka("/meal1.png", "Zahtevi za jelo");
		
		add(stavkaTipoviJela, "wrap, align center");
		add(stavkaZahteviZaJelo, "wrap, align center");
	}
	
}
