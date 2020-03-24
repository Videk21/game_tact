package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registerFrame {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPass1;
	private JPasswordField passwordFieldPass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerFrame window = new registerFrame();
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
	public registerFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(233, 22, 73, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(259, 70, 146, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(259, 101, 146, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordFieldPass1 = new JPasswordField();
		passwordFieldPass1.setBounds(259, 132, 146, 20);
		frame.getContentPane().add(passwordFieldPass1);
		
		passwordFieldPass2 = new JPasswordField();
		passwordFieldPass2.setBounds(259, 163, 146, 20);
		frame.getContentPane().add(passwordFieldPass2);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(193, 73, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(193, 104, 56, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(193, 135, 56, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblPasswordre = new JLabel("Password-re");
		lblPasswordre.setBounds(193, 166, 66, 14);
		frame.getContentPane().add(lblPasswordre);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(passwordFieldPass1.getPassword());	
				String pass2 = String.valueOf(passwordFieldPass2.getPassword());
				String usr = String.valueOf(textFieldUsername.getText());
				String email = String.valueOf(textFieldEmail.getText());

				System.out.println(pass.equals(pass2));
				System.out.println(pass);
				System.out.println(pass2);
				int num;
				if(pass.equals(pass2)) {								 
					num = dbFunctions.register(usr, email, pass);
					if(num!=0) {
						JOptionPane.showMessageDialog(frame,"Mail že obstaja.","Warning",JOptionPane.WARNING_MESSAGE);
					}
					else {
						loginFrame reg = new loginFrame();
						reg.setVisible(true);
						frame.dispose();
					}
					
				}else{
					JOptionPane.showMessageDialog(frame,"Gesli se ne ujemata.","Warning",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(260, 218, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame reg = new loginFrame();
				reg.setVisible(true);
				frame.dispose();
			}
		});
		btnLogin.setBounds(259, 246, 89, 23);
		frame.getContentPane().add(btnLogin);
	}	
	public void setVisible(boolean b) {
		registerFrame window = new registerFrame();
		window.frame.setVisible(true);	
	}
}
