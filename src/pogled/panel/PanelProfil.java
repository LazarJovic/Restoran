package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelProfil extends JPanel {

	public PanelProfil() {
		setName("Profil");
		JLabel lbl = new JLabel("PROFIL");
		add(lbl);
		setVisible(true);
	}
}
