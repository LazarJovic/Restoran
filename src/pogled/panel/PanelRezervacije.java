package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRezervacije extends JPanel {

	public PanelRezervacije() {
		setName("Rezervacije");
		JLabel lbl = new JLabel("REZERVACIJE");
		add(lbl);
		setVisible(true);
	}
}
