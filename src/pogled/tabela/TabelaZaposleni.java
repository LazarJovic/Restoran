package pogled.tabela;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import pogled.PogledUtil;

public class TabelaZaposleni extends JTable {

	public TabelaZaposleni(TabelaModelZaposleni tabelaModelZaposleni) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(tabelaModelZaposleni);
//		this.getTableHeader().setOpaque(false);
		this.getTableHeader().setBackground(PogledUtil.getPrimarnaBoja());
		this.getTableHeader().setForeground(Color.WHITE);
		this.getTableHeader().setFont(PogledUtil.getRobotoFont(14, true));
		this.setFont(PogledUtil.getRobotoFont(14, false));
		new DugmeBrisanjeZaposlenog(this, 6);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
}
