package pogled.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import izuzeci.ResultEmptyException;
import kontroler.JeloKontroler;
import kontroler.TipJelaKontroler;
import model.JeloCena;
import net.miginfocom.swing.MigLayout;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PadajucaLista;
import pogled.tabela.jelovnik.TabelaJelovnik;
import pogled.tabela.jelovnik.TabelaModelJelovnik;
import pogled.tabela.zaposleni.TabelaModelZaposleni;
import util.PogledUtil;

public class PanelJelovnik extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7893396793228337113L;
	private List<JeloCena> jelovnik;
	private JeloKontroler jeloKontroler;
	private TipJelaKontroler tipJelaKontroler;
	
	private TabelaJelovnik tabelaJelovnik;

	public PanelJelovnik() {
		setName("Jelovnik");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		//TODO: Dobavi sva jela
		jeloKontroler = new JeloKontroler();
		tipJelaKontroler = new TipJelaKontroler();
		try {
			this.jelovnik = jeloKontroler.dobaviJela();
		} catch (ResultEmptyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.INFORMATION_MESSAGE);
		}
		Labela lblNaslov = new Labela("Jelovnik restorana", fntNaslov, clrForeground);
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/menu96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		String[] naziviTipovaJela = null;
		try {
			naziviTipovaJela = tipJelaKontroler.dobaviNaziveTipovaJela();
		} catch (ResultEmptyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.INFORMATION_MESSAGE);
		}
		
		Labela lblTipJela = new Labela("Tip jela:", fntTekstPolje, clrForeground);
		PadajucaLista plTipoviZaposlenih = new PadajucaLista(naziviTipovaJela, 
				clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		//TODO: Vidljivo samo kada je sef kuhinje ulogovan
		//TODO: Dodaj action listener
		FormaDugme btnDodajJelo = new FormaDugme("Dodaj jelo", clrPrimarna, clrForeground, 150, 20);
		
		FormaDugme btnPretrazi = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 75, 20);
		
		setLayout(new MigLayout("", "80[]40[]", "90[]30[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(lblImage, "wrap, span2, align center");
		add(lblTipJela, "cell 0 2, align left");
		add(plTipoviZaposlenih, "cell 0 2, align left");
		add(btnPretrazi, "cell 0 2, gapleft 10, align left");
		add(btnDodajJelo, "cell 1 2, wrap, align right");
		
		this.inicijalizujTabeluZaposlenih();
	}
	
	private void inicijalizujTabeluZaposlenih() {
		
		TabelaModelJelovnik tabelaModelJelovnik = new TabelaModelJelovnik(jelovnik);
		this.tabelaJelovnik = new TabelaJelovnik(tabelaModelJelovnik);
		JScrollPane scrollPane = new JScrollPane(tabelaJelovnik);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelJelovnik model = (TabelaModelJelovnik) tabelaJelovnik.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
