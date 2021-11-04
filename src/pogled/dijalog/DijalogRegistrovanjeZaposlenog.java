package pogled.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import kontroler.KorisnikKontroler;
import model.Korisnik;
import net.miginfocom.swing.MigLayout;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PadajucaLista;
import pogled.PogledUtil;
import pogled.TekstPolje;

public class DijalogRegistrovanjeZaposlenog extends JDialog {
	
	private TekstPolje tfIme;
	private TekstPolje tfPrezime;
	private TekstPolje tfTelefon;
	private TekstPolje tfEmail;
	private TekstPolje tfDatumRodjenja;
	private TekstPolje tfKorIme;
	private TekstPolje tfLozinka;
	
	public DijalogRegistrovanjeZaposlenog() {}
	
	public DijalogRegistrovanjeZaposlenog(KorisnikKontroler korisnikKontroler, JTable table) {
		setSize(new Dimension(520, 650));
		setLocationRelativeTo(null);
		setTitle("Registrovanje zaposlenog");
		this.getContentPane().setBackground(PogledUtil.getPrimarnaBoja());
		
		Font fntLabela = PogledUtil.getRobotoFont(16, true);
		Font fntTekstPolje = PogledUtil.getRobotoFont(14, false);
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = Color.WHITE;
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/profile96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		Labela lblIme = new Labela("Ime:", fntLabela, clrTercijarna);
		tfIme = new TekstPolje("yy", fntTekstPolje, 140, 30);
		
		Labela lblPrezime = new Labela("Prezime:", fntLabela, clrTercijarna);
		tfPrezime = new TekstPolje("yy", fntTekstPolje, 140, 30);
				
		Labela lblTelefon = new Labela("Telefon:", fntLabela, clrTercijarna);
		tfTelefon = new TekstPolje("yy", fntTekstPolje, 140, 30);
		
		Labela lblEmail = new Labela("Email:", fntLabela, clrTercijarna);
		tfEmail = new TekstPolje("yy", fntTekstPolje, 140, 30);

		Labela lblDatumRodjenja = new Labela("Datum rodjenja:", fntLabela, clrTercijarna);
		tfDatumRodjenja = new TekstPolje("1998-12-12", fntTekstPolje, 140, 30);
		
		Labela lblKorIme = new Labela("Korisničko ime:", fntLabela, clrTercijarna);
		tfKorIme = new TekstPolje("yy", fntTekstPolje, 140, 30);
		
		Labela lblLozinka = new Labela("Lozinka:", fntLabela, clrTercijarna);
		tfLozinka = new TekstPolje("yy", fntTekstPolje, 140, 30);
		
		Labela lblTipZaposlenog = new Labela("Tip zaposlenog:", fntLabela, clrTercijarna);
		String[] tipoviZaposlenih = { "Vlasnik", "Menadžer", "Šef kuhinje", "Konobar"};
		PadajucaLista plTipoviZaposlenih = new PadajucaLista(tipoviZaposlenih,
				clrSekundarna, clrForeground, fntTekstPolje, 140, 30);
		
		FormaDugme btnRegistruj = new FormaDugme("Registruj", clrSekundarna, clrForeground, 150, 20);
		btnRegistruj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Korisnik korisnik = korisnikKontroler.registrujKorisnika(tfIme.getText(), tfPrezime.getText(), tfTelefon.getText(),
							tfEmail.getText(), tfDatumRodjenja.getText(), tfKorIme.getText(), tfLozinka.getText(),
							(String) plTipoviZaposlenih.getSelectedItem());
					close();
				} catch (MissingValueException e1) {
					System.out.println("missing value"); //TODO: Handle errors
					e1.printStackTrace();
				} catch (SQLException e1) {
					System.out.println("sql exception");
					e1.printStackTrace();
				} catch (BadFormatException e1) {
					System.out.println("los format");
					e1.printStackTrace();
				}
			}
		});
		
		setLayout(new MigLayout("", "115[]25[]", "30[]30[]15[]15[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblImage, "wrap, span2, align center");
		add(lblIme);
		add(tfIme, "wrap");
		add(lblPrezime);
		add(tfPrezime, "wrap");
		add(lblTelefon);
		add(tfTelefon, "wrap");
		add(lblEmail);
		add(tfEmail, "wrap");
		add(lblDatumRodjenja);
		add(tfDatumRodjenja, "wrap");
		add(lblKorIme);
		add(tfKorIme, "wrap");
		add(lblLozinka);
		add(tfLozinka, "wrap");
		add(lblTipZaposlenog);
		add(plTipoviZaposlenih, "wrap");
		add(btnRegistruj, "wrap, span2, align center");
	}
	
	private void close() {
		this.dispose();
	}
}
