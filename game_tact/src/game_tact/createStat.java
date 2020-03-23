package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createStat {

	private JFrame frame;
	private JTextField textFieldURL;
	private JTextField textFieldName;
	private JTextField textFieldDes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createStat window = new createStat();
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
	public createStat() {
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
		
		JLabel lblNewLabel = new JLabel("URL:");
		lblNewLabel.setBounds(42, 75, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(115, 72, 286, 20);
		frame.getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Add a new strategy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(115, 11, 223, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(115, 100, 286, 20);
		frame.getContentPane().add(textFieldName);
		
		JLabel lblIme = new JLabel("Name:");
		lblIme.setBounds(42, 103, 63, 14);
		frame.getContentPane().add(lblIme);
		
		JLabel lblOpis = new JLabel("Description:");
		lblOpis.setBounds(42, 134, 63, 14);
		frame.getContentPane().add(lblOpis);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opis = String.valueOf(textFieldDes.getText());
				String url = String.valueOf(textFieldURL.getText());
				String naslov = String.valueOf(textFieldName.getText());
				dbFunctions.dodajStrategijo(opis, naslov, url);
			}
		});
		btnUpload.setBounds(312, 216, 89, 23);
		frame.getContentPane().add(btnUpload);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(115, 216, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		textFieldDes = new JTextField();
		textFieldDes.setColumns(10);
		textFieldDes.setBounds(115, 131, 286, 20);
		frame.getContentPane().add(textFieldDes);
		
	}
	public void setVisible(boolean b) {
		createStat window = new createStat();
		window.frame.setVisible(true);	
	}
}
