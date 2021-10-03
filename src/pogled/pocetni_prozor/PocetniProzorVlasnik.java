package pogled.pocetni_prozor;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniVlasnik;

public class PocetniProzorVlasnik extends PocetniProzor {

	private MeniVlasnik meni;
	
	public PocetniProzorVlasnik() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniVlasnik) meniFabrika.napraviMeni("VLASNIK");
		
		add(meni, BorderLayout.WEST);
	}
	
}
