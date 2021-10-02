package main;

import baza.BazaPodatakaKonekcija;
import kontroler.AuthKontroler;
import pogled.PrijavaProzor;

public class Main {

	public static void main(String[] args) {
		
		BazaPodatakaKonekcija konekcija = BazaPodatakaKonekcija.getInstance();
		AuthKontroler authController = new AuthKontroler();
		PrijavaProzor lw = new PrijavaProzor(authController);
		lw.setVisible(true);
	}
}
