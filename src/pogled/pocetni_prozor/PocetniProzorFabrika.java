package pogled.pocetni_prozor;


public class PocetniProzorFabrika {

	public PocetniProzorFabrika() {}
	
	public PocetniProzor napraviPocetniProzor(String uloga) {
		switch (uloga) {
		case "VLASNIK":
			return new PocetniProzorVlasnik();
		case "MENADZER":
			return new PocetniProzorMenadzer();
		case "SEF_KUHINJE":
			return new PocetniProzorSef();
		default:
			return new PocetniProzor();
		}
	}
	
}
