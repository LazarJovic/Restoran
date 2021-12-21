package main;

import baza.BazaPodatakaKonekcija;
import pogled.PrijavaProzor;

public class Main {

	public static void main(String[] args) {
		BazaPodatakaKonekcija.getInstance();
		PrijavaProzor prijavaProzor = new PrijavaProzor();
		prijavaProzor.setVisible(true);
	}
}
