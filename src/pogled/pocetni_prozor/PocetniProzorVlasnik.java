package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniVlasnik;
import pogled.panel.PanelInfoRestorana;
import pogled.panel.PanelRezervacije;
import pogled.panel.PanelZahteviZaJelo;
import pogled.panel.PanelZaposleni;

public class PocetniProzorVlasnik extends PocetniProzor {

	private MeniVlasnik meni;
	private List<JPanel> paneli;
	
	public PocetniProzorVlasnik() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniVlasnik) meniFabrika.napraviMeni("VLASNIK");
		
		paneli = new ArrayList<>(
	            Arrays.asList(panelProfil,
	                          panelJelovnik,
	                          new PanelZaposleni(),
	                          new PanelZahteviZaJelo(),
	                          new PanelRezervacije(),
	                          new PanelInfoRestorana()));
		
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
		
		meni.getStavkaZaposleni().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Zaposleni");
				osveziProzor();
			}
		});

		meni.getStavkaZahteviZaJelo().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("ZahteviZaJelo");
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
		
		meni.getStavkaInfoRestorana().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("InfoRestorana");
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
