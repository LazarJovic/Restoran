package model;

public class Jelo {
	
	private String naziv;
	private String opis;
	private String dodatneInfo;
	private float cena;
	private String recept;
	private boolean uklonjeno;
	private TipJela tipJela;
	private SlikaJela slikaJela;
	
	public Jelo() {}
	
	public Jelo(String naziv, String opis, String dodatneInfo, float cena, String recept, boolean uklonjeno, TipJela tipJela, SlikaJela slikaJela) {
		this.naziv = naziv;
		this.opis = opis;
		this.dodatneInfo = dodatneInfo;
		this.cena = cena;
		this.recept = recept;
		this.uklonjeno = uklonjeno;
		this.tipJela = tipJela;
		this.slikaJela = slikaJela;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getDodatneInfo() {
		return dodatneInfo;
	}

	public void setDodatneInfo(String dodatneInfo) {
		this.dodatneInfo = dodatneInfo;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getRecept() {
		return recept;
	}

	public void setRecept(String recept) {
		this.recept = recept;
	}

	public boolean isUklonjeno() {
		return uklonjeno;
	}

	public void setUklonjeno(boolean uklonjeno) {
		this.uklonjeno = uklonjeno;
	}

	public TipJela getTipJela() {
		return tipJela;
	}

	public void setTipJela(TipJela tipJela) {
		this.tipJela = tipJela;
	}

	public SlikaJela getSlikaJela() {
		return slikaJela;
	}

	public void setSlikaJela(SlikaJela slikaJela) {
		this.slikaJela = slikaJela;
	}
}
