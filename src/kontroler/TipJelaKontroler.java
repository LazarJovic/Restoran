package kontroler;

import izuzeci.ResultEmptyException;
import repozitorijum.TipJelaRepo;

public class TipJelaKontroler {

	private TipJelaRepo tipJelaRepo;
	
	public TipJelaKontroler() {
		tipJelaRepo = new TipJelaRepo();
	}
	
	public String[] dobaviNaziveTipovaJela() throws ResultEmptyException {
		String[] nazivi = tipJelaRepo.dobaviNaziveTipovaJela();
		if (nazivi == null) {
			throw new ResultEmptyException("Ne postoje registrovani tipovi jela");
		}
		
		return nazivi;
	}
	
}
