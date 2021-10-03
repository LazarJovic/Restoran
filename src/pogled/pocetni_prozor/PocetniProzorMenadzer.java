package pogled.pocetni_prozor;

import java.awt.BorderLayout;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniMenadzer;

public class PocetniProzorMenadzer extends PocetniProzor {

	private MeniMenadzer meni;
	
	public PocetniProzorMenadzer() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniMenadzer) meniFabrika.napraviMeni("MENADZER");
		
		add(meni, BorderLayout.WEST);
	}
	
}
