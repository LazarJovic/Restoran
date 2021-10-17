package pogled;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class TekstPolje extends JTextField {

	public TekstPolje(String tekst, Font font, int width, int height) {
		setText(tekst);
		setFont(font);
		setPreferredSize(new Dimension(width, height));
	}
	
}
