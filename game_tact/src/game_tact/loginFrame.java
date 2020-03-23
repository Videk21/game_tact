package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame window = new loginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 42, 55, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean login;
				dbFunctions db = new dbFunctions();
				String pass = String.valueOf(passwordField.getPassword());	
				String email = String.valueOf(textField.getText());
				login = db.login(email, pass);
				if(login) {
					db.loginInfo(email);
					db.getNum();
					main mn = new main();
					mn.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(150, 165, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerFrame reg = new registerFrame();
				reg.setVisible(true);
				frame.dispose();
			}
		});
		btnRegister.setBounds(150, 191, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		textField = new JTextField();
		textField.setBounds(138, 78, 192, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(82, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 109, 192, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Geslo");
		lblNewLabel_2.setBounds(82, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
	public void setVisible(boolean b) {
		loginFrame window = new loginFrame();
		window.frame.setVisible(true);	
	}
	
}
