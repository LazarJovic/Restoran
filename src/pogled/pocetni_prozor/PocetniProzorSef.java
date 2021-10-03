package pogled.pocetni_prozor;

import java.awt.BorderLayout;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniSefKuhinje;

public class PocetniProzorSef extends PocetniProzor {

private MeniSefKuhinje meni;
	
	public PocetniProzorSef() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniSefKuhinje) meniFabrika.napraviMeni("SEF_KUHINJE");
		
		add(meni, BorderLayout.WEST);
	}
	
}
