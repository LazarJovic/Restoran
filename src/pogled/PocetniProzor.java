package pogled;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class PocetniProzor extends JFrame {

	public PocetniProzor() {
		setSize(new Dimension(800, 600));
		setTitle("Početni prozor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
	}
	
}
