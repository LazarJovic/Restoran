package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniVlasnik;
import pogled.panel.PanelInfoRestorana;
import pogled.panel.PanelJelovnik;
import pogled.panel.PanelProfil;
import pogled.panel.PanelRezervacije;
import pogled.panel.PanelZahteviZaJelo;
import pogled.panel.PanelZaposleni;

public class PocetniProzorVlasnik extends PocetniProzor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6761965705200164299L;
	private MeniVlasnik meni;
	
	public PocetniProzorVlasnik() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniVlasnik) meniFabrika.napraviMeni("VLASNIK");
		
		paneli = new ArrayList<>(
	            Arrays.asList(new PanelProfil(),
	                          new PanelJelovnik(),
	                          new PanelZaposleni(),
	                          new PanelZahteviZaJelo(),
	                          new PanelRezervacije(),
	                          new PanelInfoRestorana()));
		
		add(paneli.get(0), BorderLayout.CENTER);
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
}
