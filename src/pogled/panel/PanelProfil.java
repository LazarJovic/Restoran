package pogled.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kontroler.KorisnikKontroler;
import model.Korisnik;
import model.PrijavljenKorisnik;
import net.miginfocom.swing.MigLayout;
import observer.IzmenaKorisnikaEvent;
import observer.Observer;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PogledUtil;
import pogled.dijalog.DialogIzmenaProfila;

public class PanelProfil extends JPanel implements Observer {
	
	private PrijavljenKorisnik prijavljenKorisnik = PrijavljenKorisnik.getInstance();
	private Korisnik korisnik;
	private KorisnikKontroler korisnikKontroler;
	
	private Labela lblImeVr;
	private Labela lblPrezimeVr;
	private Labela lblTelefonVr;
	private Labela lblEmailVr;
	
	public PanelProfil() {
		setName("Profil");
		setVisible(true);
		setBackground(PogledUtil.getSekundarnaBoja());
		
		korisnikKontroler = new KorisnikKontroler();
		korisnik = korisnikKontroler.dobaviKorisnikaPoKorImenu(prijavljenKorisnik.getKorisnickoIme());
		korisnikKontroler.setKorisnik(korisnik);
		korisnik.addObserver(this);
		
		Font fntNaslov = PogledUtil.getRobotoFont(24, true);
		Font fntLabela = PogledUtil.getRobotoFont(16, true);
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = Color.WHITE;
		
		Labela lblNaslov = new Labela("Pregled i izmena profilnih podataka", fntNaslov, clrForeground);
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/profile96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		Labela lblIme = new Labela("Ime:", fntLabela, clrTercijarna);
		lblImeVr = new Labela(korisnik.getIme(), fntLabela, clrForeground);
		Labela lblPrezime = new Labela("Prezime:", fntLabela, clrTercijarna);
		lblPrezimeVr = new Labela(korisnik.getPrezime(), fntLabela, clrForeground);
		Labela lblKorIme = new Labela("Korisnicko ime:", fntLabela, clrTercijarna);
		Labela lblKorImeVr = new Labela(korisnik.getKorisnickiNalog().getKorisnickoIme(), fntLabela, clrForeground);
		Labela lblUloga = new Labela("Uloga:", fntLabela, clrTercijarna);
		Labela lblUlogaVr = new Labela(korisnik.getKorisnickiNalog().getUloga().toString(), fntLabela, clrForeground);
		Labela lblTelefon = new Labela("Telefon:", fntLabela, clrTercijarna);
		lblTelefonVr = new Labela(korisnik.getTelefon(), fntLabela, clrForeground);
		Labela lblEmail = new Labela("Email:", fntLabela, clrTercijarna);
		lblEmailVr = new Labela(korisnik.getEmail(), fntLabela, clrForeground);
		Labela lblDatumZap = new Labela("Datum zaposlenja:", fntLabela, clrTercijarna);
		Labela lblDatumZapVr = new Labela(PogledUtil.getFormatDatuma().format(korisnik.getDatumZaposlenja()), fntLabela, clrForeground);
		Labela lblDatumRodj = new Labela("Datum rodjenja:", fntLabela, clrTercijarna);
		Labela lblDatumRodjVr = new Labela(PogledUtil.getFormatDatuma().format(korisnik.getDatumRodjenja()), fntLabela, clrForeground);
	
		FormaDugme btnIzmena = new FormaDugme("Izmena", clrPrimarna, clrForeground, 150, 20);
		btnIzmena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmenaProfila dialogIzmenaProfila = new DialogIzmenaProfila(korisnik, korisnikKontroler);
				dialogIzmenaProfila.setVisible(true);
			}
		});
		
		FormaDugme btnIzmenaLozinke = new FormaDugme("Promena lozinke", clrPrimarna, clrForeground, 150, 20);
	
		setLayout(new MigLayout("", "210[]5[]30[]5[]", "150[]30[]40[]15[]15[]15[]35[]150[]"));
		
		add(lblNaslov, "wrap, span4, gapright 240, align center");
		add(lblImage, "wrap, span4, gapright 270, align center");
		add(lblIme);
		add(lblImeVr);
		add(lblPrezime);
		add(lblPrezimeVr, "wrap");
		add(lblKorIme);
		add(lblKorImeVr);
		add(lblUloga);
		add(lblUlogaVr, "wrap");
		add(lblTelefon);
		add(lblTelefonVr);
		add(lblEmail);
		add(lblEmailVr, "wrap");
		add(lblDatumZap);
		add(lblDatumZapVr);
		add(lblDatumRodj);
		add(lblDatumRodjVr, "wrap");
		add(btnIzmena, "wrap, span4, gapright 280, align center");
		add(btnIzmenaLozinke, "span4, gapleft 600, align right");
	}

	@Override
	public void updatePerformed(EventObject e) {
		IzmenaKorisnikaEvent izmenaKorisnikaEvent = (IzmenaKorisnikaEvent) e;
		lblImeVr.setText(izmenaKorisnikaEvent.getIme());
		lblPrezimeVr.setText(izmenaKorisnikaEvent.getPrezime());
		lblTelefonVr.setText(izmenaKorisnikaEvent.getTelefon());
		lblEmailVr.setText(izmenaKorisnikaEvent.getEmail());
		this.repaint();
	}

}
