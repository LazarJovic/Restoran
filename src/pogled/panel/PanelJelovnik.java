package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJelovnik extends JPanel {

	public PanelJelovnik() {
		setName("Jelovnik");
		JLabel lbl = new JLabel("JELOVNIK");
		add(lbl);
		setVisible(true);
	}
}
