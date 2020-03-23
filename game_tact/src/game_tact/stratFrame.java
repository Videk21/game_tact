package game_tact;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;

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
	        url = new URL("https://image.winudf.com/v2/image/Y29tLmtvYWxpdHlnYW1lLnI2c2llZ2V0YWN0aWNzX3NjcmVlbl80X3NrcHl4b2tn/screen-4.jpg?fakeurl=1&type=.jpg");
	        image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);

            
	}
	public void setVisible(boolean b) {
		stratFrame window = new stratFrame();
		window.frame.setVisible(true);	
	}

}
