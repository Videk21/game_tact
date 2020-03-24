package game_tact;

import java.awt.EventQueue;
import java.awt.Image;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class stratFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stratFrame window = new stratFrame();
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
	public stratFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image image = null;
		URL url = null;
	    try {
	        url = new URL(dbFunctions.gURL);
	        image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);

            
	}
	public void setVisible(boolean b) {
		stratFrame window = new stratFrame();
		window.frame.setVisible(true);	
	}

}
