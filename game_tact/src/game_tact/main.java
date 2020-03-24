package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;

public class main {
	private JFrame frame;
	private JTextField textFieldComent;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dbFunctions.getInfo();

		
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextArea textAreaOpis = new JTextArea(dbFunctions.Ops);
		textAreaOpis.setBounds(199, 45, 282, 118);
		frame.getContentPane().add(textAreaOpis);
		
		
		JButton btnComent = new JButton("Coment");
		btnComent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opis = String.valueOf(textFieldComent.getText());
				dbFunctions.dodajKomentar(opis);
			}
		});
		btnComent.setBounds(491, 319, 89, 23);
		frame.getContentPane().add(btnComent);
		
		JButton btnNewButton = new JButton("Open strategy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stratFrame sF = new stratFrame();
				sF.setVisible(true);
			}
		});
		btnNewButton.setBounds(360, 11, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbFunctions.backStrat();				
			}
		});
		btnBack.setBounds(193, 351, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textFieldComent = new JTextField();
		textFieldComent.setBounds(199, 320, 282, 20);
		frame.getContentPane().add(textFieldComent);
		textFieldComent.setColumns(10);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = dbFunctions.id;
				System.out.println(id);
				userSetting us = new userSetting();
				us.setVisible(true);
			}
		});
		btnOptions.setBounds(41, 30, 126, 23);
		frame.getContentPane().add(btnOptions);
		
		JButton btnNewButton_1 = new JButton("Add strategy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStat cs = new createStat();
				cs.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(281, 351, 126, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		final JLabel lblNewLabel = new JLabel(dbFunctions.Nsv);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(199, 15, 151, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				dbFunctions.nextStrat();
				//lblNewLabel.setText():
				textAreaOpis.setText(dbFunctions.Ops);
				lblNewLabel.setText(dbFunctions.Nsv);

			}
		});
		btnNext.setBounds(404, 351, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JList listComent = new JList();
		listComent.setBounds(199, 174, 282, 139);
		frame.getContentPane().add(listComent);
		//JList<String> list = JList<String>();
		
		
		JButton btnEdit = new JButton("Edit strategy");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStrategy eS = new editStrategy();
				eS.setVisible(true);
			}
		});
		btnEdit.setBounds(41, 65, 126, 23);
		frame.getContentPane().add(btnEdit);
		
	}
	public void setVisible(boolean b) {
		main window = new main();
		window.frame.setVisible(true);	
	}
}
