package kontroler;

import java.util.ArrayList;
import java.util.List;

import izuzeci.ResultEmptyException;
import model.JeloCena;
import repozitorijum.JeloRepo;

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
}
