package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editStrategy {

	private JFrame frame;
	private JTextField textFieldURL;
	private JTextField textFieldName;
	private JTextField textFieldDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editStrategy window = new editStrategy();
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
	public editStrategy() {
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
		
		JLabel label = new JLabel("URL:");
		label.setBounds(29, 75, 63, 14);
		frame.getContentPane().add(label);
		
		textFieldURL = new JTextField(dbFunctions.gURL);
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(102, 72, 286, 20);
		frame.getContentPane().add(textFieldURL);
		
		JLabel lblEditStrategy = new JLabel("Edit strategy");
		lblEditStrategy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEditStrategy.setBounds(150, 11, 223, 50);
		frame.getContentPane().add(lblEditStrategy);
		
		textFieldName = new JTextField(dbFunctions.Nsv);
		textFieldName.setColumns(10);
		textFieldName.setBounds(102, 100, 286, 20);
		frame.getContentPane().add(textFieldName);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setBounds(29, 103, 63, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Description:");
		label_3.setBounds(29, 134, 63, 14);
		frame.getContentPane().add(label_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opis = String.valueOf(textFieldDesc.getText());
				String url = String.valueOf(textFieldURL.getText());
				String naslov = String.valueOf(textFieldName.getText());
				dbFunctions.posodobiStrategijo(opis, naslov, url);
			}
		});
		btnUpdate.setBounds(299, 191, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(29, 191, 89, 23);
		frame.getContentPane().add(button_1);
		
		textFieldDesc = new JTextField(dbFunctions.Ops);
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(102, 131, 286, 20);
		frame.getContentPane().add(textFieldDesc);
		
		JButton btnDelet = new JButton("Delete");
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelet.setBounds(200, 191, 89, 23);
		frame.getContentPane().add(btnDelet);
	}
	public void setVisible(boolean b) {
		editStrategy eS = new editStrategy();
		eS.frame.setVisible(true);
	}
}
