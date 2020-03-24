package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userSetting {

	private JFrame frame;
	private JTextField textFieldSUsr;
	private JTextField textFieldEmail;
	private JTextField textFieldPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userSetting window = new userSetting();
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
	public userSetting() {
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
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String usr = String.valueOf(textFieldSUsr.getText());
				String email = String.valueOf(textFieldEmail.getText());
				String geslo = String.valueOf(textFieldPass.getText());
				dbFunctions.updateUser(email, geslo, usr);
			}
		});
		btnSave.setBounds(252, 155, 89, 23);
		frame.getContentPane().add(btnSave);
		
		textFieldSUsr = new JTextField(dbFunctions.username);
		textFieldSUsr.setBounds(180, 64, 161, 20);
		frame.getContentPane().add(textFieldSUsr);
		textFieldSUsr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(109, 67, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Options");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldEmail = new JTextField(dbFunctions.gmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(180, 93, 161, 20);
		frame.getContentPane().add(textFieldEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(109, 96, 73, 14);
		frame.getContentPane().add(lblEmail);
		
		textFieldPass = new JTextField(dbFunctions.pass);
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(180, 124, 161, 20);
		frame.getContentPane().add(textFieldPass);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(109, 127, 73, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancle.setBounds(109, 155, 89, 23);
		frame.getContentPane().add(btnCancle);
	}
	public void setVisible(boolean b) {
		userSetting window = new userSetting();
		window.frame.setVisible(true);	
	}
}
