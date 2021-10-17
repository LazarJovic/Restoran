package main;

import baza.BazaPodatakaKonekcija;
import pogled.PrijavaProzor;

public class Main {

	public static void main(String[] args) {
		
		BazaPodatakaKonekcija konekcija = BazaPodatakaKonekcija.getInstance();
		PrijavaProzor lw = new PrijavaProzor();
		lw.setVisible(true);
	}
}
