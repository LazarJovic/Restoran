package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.PrijavljenKorisnik;

public class PocetniProzor extends JFrame {

	public PocetniProzor() {
		setSize(new Dimension(1300, 800));
		setTitle("Sistem za upravljanje restoranom");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}
	
}
