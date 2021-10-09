package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import izuzeci.NotFoundException;
import kontroler.AuthKontroler;
import model.PrijavljenKorisnik;
import net.miginfocom.swing.MigLayout;
import pogled.pocetni_prozor.PocetniProzor;
import pogled.pocetni_prozor.PocetniProzorFabrika;

public class PrijavaProzor extends JFrame {
	
	private JTextField tfKorIme;
	private JTextField tfLozinka;
	
	private AuthKontroler authController;
	
	public PrijavaProzor() {};
	
	public PrijavaProzor(AuthKontroler authController) {
		
		setSize(new Dimension(500, 400));
		setTitle("Prijava");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Font fntNaslov = PogledUtil.getRobotoFont(16);
		Font fntLabela = PogledUtil.getRobotoFont(13);
		Color clrForeground = Color.WHITE;
		JPanel pnlPrijava = new JPanel();
		Labela lblNaslov = new Labela("Prijavite se na sistem restorana", fntNaslov, clrForeground);
		JLabel lblImage = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/restaurant1.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		Labela lblKorIme = new Labela("Korisnicko ime: ", fntLabela, clrForeground);
		tfKorIme = new JTextField(50);
		Labela lblLozinka = new Labela("Lozinka: ", fntLabela, clrForeground);
		tfLozinka = new JTextField(50);
		FormaDugme btnPrijava = new FormaDugme("Prijava", new Color(16, 97, 4), Color.WHITE, 70, 20);
		btnPrijava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					String uloga = authController.login(tfKorIme.getText(), tfLozinka.getText());
					close();
					PocetniProzor procetniProzor = new PocetniProzorFabrika().napraviPocetniProzor(uloga);
					procetniProzor.setVisible(true);
				} catch (MissingValueException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (BadCredentialsException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		
		FormaDugme btnIzlaz = new FormaDugme("Izlaz",new Color(16, 97, 4), Color.WHITE, 70, 20);
		
		pnlPrijava.setBackground(new Color(16, 97, 4));
		pnlPrijava.setLayout(new MigLayout("", "[][]", "30[]20[]20[]10[]10[]"));
		
		pnlPrijava.add(lblNaslov, "wrap, span2, align center");
		pnlPrijava.add(lblImage, "wrap, span2, align center");
		pnlPrijava.add(lblKorIme, "gapleft 30");
		pnlPrijava.add(tfKorIme, "wrap, pushx, growx, gapright 30");
		pnlPrijava.add(lblLozinka, "gapleft 30");
		pnlPrijava.add(tfLozinka, "wrap, pushx, growx, gapright 30");
		pnlPrijava.add(btnPrijava, "span2, split2, align right");
		pnlPrijava.add(btnIzlaz, "gapright 30");
		add(pnlPrijava);
	}
	
	private void close() {
		this.dispose();
	}
}
