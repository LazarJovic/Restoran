package model;

import java.util.HashSet;
import java.util.Set;

public class TipJela {
	
	private String naziv;
	private Set<Jelo> jela;
	
	public TipJela() {}

	public TipJela(String naziv) {
		super();
		this.naziv = naziv;
		jela = new HashSet();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Jelo> getJela() {
		return jela;
	}

	public void setJela(Set<Jelo> jela) {
		this.jela = jela;
	}
}
