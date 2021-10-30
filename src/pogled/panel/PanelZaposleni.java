package pogled.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import izuzeci.ResultEmptyException;
import kontroler.KorisnikKontroler;
import model.Korisnik;
import net.miginfocom.swing.MigLayout;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PogledUtil;
import pogled.TekstPolje;
import pogled.tabela.TabelaModelZaposleni;
import pogled.tabela.TabelaZaposleni;

public class PanelZaposleni extends JPanel {

	private List<Korisnik> korisnici;
	private KorisnikKontroler korisnikKontroler;
	
	private TabelaZaposleni tabelaZaposleni;
	
	public PanelZaposleni() {
		setName("Zaposleni");
		setVisible(true);
		setBackground(PogledUtil.getSekundarnaBoja());
		
		korisnikKontroler = new KorisnikKontroler();
		try {
			this.korisnici = korisnikKontroler.dobaviKorisnike();
		} catch (ResultEmptyException e) {
			System.out.println(e.getMessage());
		}
		
		Font fntNaslov = PogledUtil.getRobotoFont(24, true);
		Font fntLabela = PogledUtil.getRobotoFont(16, true);
		Font fntTekstPolje = PogledUtil.getRobotoFont(14, false);
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = Color.WHITE;
		
		Labela lblNaslov = new Labela("Pregled i registrovanje zaposlenih", fntNaslov, clrForeground);
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/employees96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		Labela lblTipZaposlenog = new Labela("Tip zaposlenog:", fntTekstPolje, clrForeground);
		TekstPolje tfTipZaposlenog = new TekstPolje("", fntTekstPolje, 140, 30);
		FormaDugme btnDodajZaposlenog = new FormaDugme("Registruj zaposlenog", clrPrimarna, clrForeground, 150, 20);
		FormaDugme btnPretrazi = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 75, 20);
		
		setLayout(new MigLayout("", "80[]40[]", "90[]30[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(lblImage, "wrap, span2, align center");
		add(lblTipZaposlenog, "cell 0 2, align left");
		add(tfTipZaposlenog, "cell 0 2, align left");
		add(btnPretrazi, "cell 0 2, gapleft 10, align left");
		add(btnDodajZaposlenog, "cell 1 2, wrap, align right");
		
		this.inicijalizujTabeluZaposlenih();
	}
	
	private void azurirajPrikaz() {
		TabelaModelZaposleni model = (TabelaModelZaposleni) tabelaZaposleni.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	private void inicijalizujTabeluZaposlenih() {
		
		TabelaModelZaposleni tabelaModelZaposleni = new TabelaModelZaposleni(korisnici);
		this.tabelaZaposleni = new TabelaZaposleni(tabelaModelZaposleni);
		JScrollPane scrollPane = new JScrollPane(tabelaZaposleni);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
}
