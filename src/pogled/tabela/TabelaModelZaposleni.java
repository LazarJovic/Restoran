package pogled.tabela;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Korisnik;
import pogled.PogledUtil;

public class TabelaModelZaposleni extends AbstractTableModel {

	private List<Korisnik> korisnici;
	
	public TabelaModelZaposleni(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return korisnici.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Ime";
		case 1:
			return "Prezime";
		case 2:
			return "Telefon";
		case 3:
			return "Email adresa";
		case 4:
			return "Uloga";
		case 5:
			return "Datum zaposlenja";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return String.class;
		case 6:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Korisnik korisnik = korisnici.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return korisnik.getIme();
		case 1:
			return korisnik.getPrezime();
		case 2:
			return korisnik.getTelefon();
		case 3:
			return korisnik.getEmail();
		case 4:
			return korisnik.getKorisnickiNalog().getUloga().toString();
		case 5:
			return PogledUtil.getFormatDatuma().format(korisnik.getDatumZaposlenja());
		case 6:
			return new JButton();
		default:
			return "";
		}
	}

}
