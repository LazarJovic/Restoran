package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FormButton extends JButton {
	
	private String text;
	private Color backColor;
	private Color foreColor;
	private int width;
	private int height;
	
	public FormButton(String text, Color backColor, Color foreColor, int width, int height) {
		this.backColor = backColor;
		this.foreColor = foreColor;
		this.setText(text);
		this.setPreferredSize(new Dimension(width, height));
		this.setForeground(foreColor);
		this.setBackground(backColor);
		this.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(foreColor, 2), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
//		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
//		Color color = btnLogin.getBackground();
//	    public void mouseEntered(java.awt.event.MouseEvent evt) {
//	    	btnLogin.setBackground(Color.WHITE);
//	    	btnLogin.setForeground(color);
//	    }
//
//	    public void mouseExited(java.awt.event.MouseEvent evt) {
//	    	btnLogin.setBorder(BorderFactory.createCompoundBorder(
//			        BorderFactory.createLineBorder(Color.WHITE, 2), 
//			        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//	    	btnLogin.setBackground(color);
//	    	btnLogin.setForeground(Color.WHITE);
//	    }
//	});
	}
}
