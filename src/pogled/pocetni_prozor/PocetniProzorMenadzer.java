package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniMenadzer;
import pogled.panel.PanelRezervacije;
import pogled.panel.PanelTipoviJela;
import pogled.panel.PanelZahteviZaJelo;

public class PocetniProzorMenadzer extends PocetniProzor {

	private MeniMenadzer meni;
	private List<JPanel> paneli;
	
	public PocetniProzorMenadzer() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniMenadzer) meniFabrika.napraviMeni("MENADZER");
		
		paneli = new ArrayList<>(
	            Arrays.asList(panelProfil,
	                          panelJelovnik,
	                          new PanelRezervacije()));
		
		add(meni, BorderLayout.WEST);
		
		meni.getStavkaProfil().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Profil");
				osveziProzor();
			}
		});
		
		meni.getStavkaJelovnik().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Jelovnik");
				osveziProzor();
			}
		});
		
		meni.getStavkaRezervacije().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Rezervacije");
				osveziProzor();
			}
		});
	}
	
	private void osveziProzor() {
		this.revalidate();
		this.repaint();
	}
	
	private void postaviPanel(String imePanela) {
		for (JPanel panel : paneli) {
			if (panel.getName().equals(imePanela)) {
				add(panel, BorderLayout.CENTER);
			} else {
				remove(panel);
			}
		}
	}
}
