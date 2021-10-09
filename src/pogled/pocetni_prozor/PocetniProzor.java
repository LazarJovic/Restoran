package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import pogled.panel.PanelJelovnik;
import pogled.panel.PanelProfil;

public class PocetniProzor extends JFrame {

	protected PanelProfil panelProfil;
	protected PanelJelovnik panelJelovnik;
	
	public PocetniProzor() {
		setSize(new Dimension(1300, 800));
		setTitle("Sistem za upravljanje restoranom");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		this.panelProfil = new PanelProfil();
		this.panelJelovnik = new PanelJelovnik();
		
		add(panelProfil, BorderLayout.CENTER);
		//add(panelJelovnik, BorderLayout.CENTER);
	}
	
	public PanelProfil getPanelProfil() {
		return this.panelProfil;
	}
	
	public PanelJelovnik getPanelJelovnik() {
		return this.panelJelovnik;
	}
	
}
