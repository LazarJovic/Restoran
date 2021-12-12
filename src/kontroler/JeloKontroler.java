package kontroler;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.NotSavedException;
import izuzeci.ResultEmptyException;
import model.JeloCena;
import repozitorijum.JeloRepo;
import util.Fajlovi;
import util.Validacija;

public class JeloKontroler {

	private JeloRepo jeloRepo;
	private List<JeloCena> jela;
	
	public JeloKontroler() {
		this.jeloRepo = new JeloRepo();
		jela = new ArrayList<JeloCena>();
	}
	
	public List<JeloCena> dobaviJela() throws ResultEmptyException {
		jela = jeloRepo.dobaviJelaSaCenama();
		if (jela.size() == 0) {
			throw new ResultEmptyException("Nema jela dodatih u jelovnik.");
		}
		
		return jela;
	}
	
	public JeloCena dodajJelo(String naziv, String tipJela, String opis, String recept, String cena, File selektovanaSlika) throws
	MissingValueException, BadFormatException, NotSavedException {
		if (Validacija.praznaIliNepostojecaVrednost(naziv)) {
			throw new MissingValueException("Nije unet naziv jela.");
		} else if (Validacija.praznaIliNepostojecaVrednost(tipJela)) {
			throw new MissingValueException("Nije odabran tip jela.");
		} else if (Validacija.praznaIliNepostojecaVrednost(opis)) {
			throw new MissingValueException("Nije uent opis jela.");
		} else if (Validacija.praznaIliNepostojecaVrednost(recept)) {
			throw new MissingValueException("Nije validno unet recept jela.");
		} else if (selektovanaSlika == null) {
			throw new MissingValueException("Nije odabrana slika jela.");
		}
		
		try {
			Float.parseFloat(cena);
		} catch (NumberFormatException e) {
			throw new BadFormatException("Cena jela treba da bude broj.");
		}
		
		Image slika = Fajlovi.dobaviSlikuOdFajla(selektovanaSlika);
		boolean sacuvana = Fajlovi.sacuvajSliku(selektovanaSlika, slika);
		
		if (!sacuvana) {
			throw new NotSavedException("Slika nije uspešno sačuvana!");
		}
		
		JeloCena dodatoJelo = jeloRepo.dodajJelo(naziv, tipJela, opis, recept, Float.parseFloat(cena), "/" + selektovanaSlika.getName());
		if (dodatoJelo == null) {
			throw new NotSavedException("Jelo nije uspešno dodato.");
		}
		
		return dodatoJelo;
	}
}
