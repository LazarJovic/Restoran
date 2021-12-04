package pogled.tabela.jelovnik;

import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Jelo;
import model.Korisnik;
import util.PogledUtil;

public class TabelaModelJelovnik extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2987067730871371449L;
	private List<Jelo> jela;
	
	public TabelaModelJelovnik(List<Jelo> jela) {
		this.jela = jela;
	}
	
	public void dodajJelo(Jelo jelo) {
		this.jela.add(jelo);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return jela.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Prikaz";
		case 1:
			return "Tip jela";
		case 2:
			return "Naziv";
		case 3:
			return "Opis";
		case 4:
			return "Cena";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Icon.class;
		case 1:
		case 2:
		case 3:
			return String.class;
		case 4:
			return Float.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
