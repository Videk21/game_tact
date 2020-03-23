package game_tact;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textAreaOpis = new JTextArea();
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
		btnNewButton.setBounds(199, 11, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(404, 351, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(193, 351, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textFieldComent = new JTextField();
		textFieldComent.setBounds(199, 320, 282, 20);
		frame.getContentPane().add(textFieldComent);
		textFieldComent.setColumns(10);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbFunctions db = new dbFunctions();
				int id = db.id;
				System.out.println(id);
				userSetting us = new userSetting();
				us.setVisible(true);
			}
		});
		btnOptions.setBounds(78, 30, 89, 23);
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
		
		JList list = new JList();
		list.setBounds(199, 200, 282, 118);
		frame.getContentPane().add(list);
		
	}
	public void setVisible(boolean b) {
		main window = new main();
		window.frame.setVisible(true);	
	}
}
