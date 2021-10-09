package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelZahteviZaJelo extends JPanel {

	public PanelZahteviZaJelo() {
		setName("ZahteviZaJelo");
		JLabel lbl = new JLabel("ZAHTEVI ZA JELO");
		add(lbl);
		setVisible(true);
	}
}
