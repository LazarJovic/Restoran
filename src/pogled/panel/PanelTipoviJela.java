package pogled.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTipoviJela extends JPanel {
	
	public PanelTipoviJela() {
		setName("TipoviJela");
		JLabel lbl = new JLabel("TIPOVI JELA");
		add(lbl);
		setVisible(true);
	}
}
