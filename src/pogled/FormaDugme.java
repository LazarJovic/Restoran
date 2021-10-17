package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FormaDugme extends JButton {
		
	public FormaDugme(String text, Color backColor, Color foreColor, int width, int height) {
		this.setText(text);
		this.setPreferredSize(new Dimension(width, height));
		this.setForeground(foreColor);
		this.setBackground(backColor);
		this.setFont(PogledUtil.getRobotoFont(13, true));
		this.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(foreColor, 2), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}
}
