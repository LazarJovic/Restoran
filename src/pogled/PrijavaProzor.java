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
import net.miginfocom.swing.MigLayout;

public class PrijavaProzor extends JFrame {
	
	private JLabel lblUsername;
	private JTextField tfUsername;
	private JLabel lblPassword;
	private JTextField tfPassword;
	
	private AuthKontroler authController;
	
	public PrijavaProzor() {};
	
	public PrijavaProzor(AuthKontroler authController) {
		
		setSize(new Dimension(500, 400));
		setTitle("Prijava");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Font fntTitle = new Font("roboto", Font.BOLD, 14);
		
		JPanel loginFormPanel = new JPanel();
		JLabel lblTitle = new JLabel("Prijavite se na sistem restorana");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(fntTitle);
		JLabel lblImage = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/restaurant1.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		lblUsername = new JLabel("Korisnicko ime: ");
		lblUsername.setForeground(Color.WHITE);
		tfUsername = new JTextField(50);
		lblPassword = new JLabel("Lozinka: ");
		lblPassword.setForeground(Color.WHITE);
		tfPassword = new JTextField(50);
		FormaDugme btnLogin = new FormaDugme("Prijava",new Color(16, 97, 4), Color.WHITE, 70, 20);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					boolean isOk = authController.login(tfUsername.getText(), tfPassword.getText());
					close();
					PocetniProzor procetniProzor = new PocetniProzor();
				} catch (MissingValueException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (BadCredentialsException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		FormaDugme btnExit = new FormaDugme("Izlaz",new Color(16, 97, 4), Color.WHITE, 70, 20);
		
		loginFormPanel.setBackground(new Color(16, 97, 4));
		loginFormPanel.setLayout(new MigLayout("", "[][]", "30[]20[]20[]10[]10[]"));
		
		loginFormPanel.add(lblTitle, "wrap, span2, align center");
		loginFormPanel.add(lblImage, "wrap, span2, align center");
		loginFormPanel.add(lblUsername, "gapleft 30");
		loginFormPanel.add(tfUsername, "wrap, pushx, growx, gapright 30");
		loginFormPanel.add(lblPassword, "gapleft 30");
		loginFormPanel.add(tfPassword, "wrap, pushx, growx, gapright 30");
		loginFormPanel.add(btnLogin, "span2, split2, align right");
		loginFormPanel.add(btnExit, "gapright 30");
		add(loginFormPanel);
	}
	
	private void close() {
		this.dispose();
	}
}
