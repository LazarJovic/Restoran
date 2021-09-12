package pogled;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class LoginWindow extends JFrame {
	
	private JLabel lblUsername;
	private JTextField tfUsername;
	private JLabel lblPassword;
	private JTextField tfPassword;
	
	public LoginWindow() {
		
		setSize(new Dimension(400, 600));
		
		JPanel loginFormPanel = new JPanel();
		lblUsername = new JLabel("Korisnicko ime: ");
		tfUsername = new JTextField(50);
		lblPassword = new JLabel("Lozinka: ");
		tfPassword = new JTextField(50);
		
		setLayout(new MigLayout("debug", "[]30[]", "[]50[]"));
		
		add(lblUsername, "cell 0 0");
		add(tfUsername, "cell 1 0");
		add(lblPassword, "cell 0 1");
		add(tfPassword, "cell 1 1");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
