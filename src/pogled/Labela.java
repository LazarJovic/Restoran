package pogled;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Labela extends JLabel {
	
	public Labela(String tekst, Font font, Color frgColor) {
		setText(tekst);
		setFont(font);
		setForeground(frgColor);
	}
}
