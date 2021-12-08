package model;

import java.util.HashSet;
import java.util.Set;

public class TipJela {
	
	private int id;
	private String naziv;
	private Set<Jelo> jela;
	
	public TipJela() {}

	public TipJela(String naziv) {
		super();
		this.naziv = naziv;
		jela = new HashSet();
	}
	
	public TipJela(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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
