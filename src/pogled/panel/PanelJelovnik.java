package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJelovnik extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7893396793228337113L;

	public PanelJelovnik() {
		setName("Jelovnik");
		JLabel lbl = new JLabel("JELOVNIK");
		add(lbl);
		setVisible(true);
	}
}
