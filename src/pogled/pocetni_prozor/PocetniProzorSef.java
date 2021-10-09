package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import pogled.meni.MeniFabrika;
import pogled.meni.MeniSefKuhinje;
import pogled.panel.PanelInfoRestorana;
import pogled.panel.PanelRezervacije;
import pogled.panel.PanelTipoviJela;
import pogled.panel.PanelZahteviZaJelo;
import pogled.panel.PanelZaposleni;

public class PocetniProzorSef extends PocetniProzor {

	private MeniSefKuhinje meni;
	private List<JPanel> paneli;
	
	public PocetniProzorSef() {
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniSefKuhinje) meniFabrika.napraviMeni("SEF_KUHINJE");
		
		paneli = new ArrayList<>(
	            Arrays.asList(panelProfil,
	                          panelJelovnik,
	                          new PanelTipoviJela(),
	                          new PanelZahteviZaJelo()));
		
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
		
		meni.getStavkaTipoviJela().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("TipoviJela");
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
