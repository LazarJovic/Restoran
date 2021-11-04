package pogled.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import izuzeci.ResultEmptyException;
import kontroler.KorisnikKontroler;
import model.Korisnik;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PadajucaLista;
import pogled.PogledUtil;
import pogled.dijalog.DijalogRegistrovanjeZaposlenog;
import pogled.tabela.TabelaModelZaposleni;
import pogled.tabela.TabelaZaposleni;

public class PanelZaposleni extends JPanel implements Observer {

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
		String[] tipoviZaposlenih = { "Vlasnik", "Menadžer", "Šef kuhinje", "Konobar"};
		PadajucaLista plTipoviZaposlenih = new PadajucaLista(tipoviZaposlenih,
				clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		FormaDugme btnDodajZaposlenog = new FormaDugme("Registruj zaposlenog", clrPrimarna, clrForeground, 150, 20);
		btnDodajZaposlenog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogRegistrovanjeZaposlenog dijalogRegistrovanjeZaposlenog = new DijalogRegistrovanjeZaposlenog(korisnikKontroler, (TabelaModelZaposleni) tabelaZaposleni.getModel());
				dijalogRegistrovanjeZaposlenog.setVisible(true);
			}
		});
		
		FormaDugme btnPretrazi = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 75, 20);
		
		setLayout(new MigLayout("", "80[]40[]", "90[]30[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(lblImage, "wrap, span2, align center");
		add(lblTipZaposlenog, "cell 0 2, align left");
		add(plTipoviZaposlenih, "cell 0 2, align left");
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
		tabelaModelZaposleni.addObserver(this);
		this.tabelaZaposleni = new TabelaZaposleni(tabelaModelZaposleni);
		JScrollPane scrollPane = new JScrollPane(tabelaZaposleni);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}

	@Override
	public void updatePerformed(EventObject e) {
		azurirajPrikaz();
	}
}
