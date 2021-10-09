package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelZaposleni extends JPanel {

	public PanelZaposleni() {
		setName("Zaposleni");
		JLabel lbl = new JLabel("ZAPOSLENI");
		add(lbl);
		setVisible(true);
	}
}
