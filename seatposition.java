package guitest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class seatposition extends JFrame {

	private JFrame frmSeatPosition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seatposition window = new seatposition();
					window.frmSeatPosition.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public seatposition() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeatPosition = new JFrame();
		frmSeatPosition.setTitle("Seat Position");
		frmSeatPosition.getContentPane().setBackground(Color.BLACK);
		frmSeatPosition.setBounds(100, 100, 837, 753);
		frmSeatPosition.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeatPosition.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back to Movie Selection");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book.main(null);
				frmSeatPosition.setVisible(false);
			}
		});
		btnNewButton.setBounds(65, 11, 169, 23);
		frmSeatPosition.getContentPane().add(btnNewButton);
		
		JButton btnBackToMovie = new JButton("Back to Movie Selection (Non-member)");
		btnBackToMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booknonmember.main(null);
				frmSeatPosition.setVisible(false);
			}
		});
		btnBackToMovie.setBounds(542, 11, 268, 23);
		frmSeatPosition.getContentPane().add(btnBackToMovie);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Joeri\\OneDrive\\Desktop\\cinemaseat.jpg"));
		lblNewLabel.setBounds(10, 11, 1280, 720);
		frmSeatPosition.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frmSeatPosition.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmSeatPosition.setVisible(true);
				}
				
			}
		});
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmSeatPosition.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		mnNewMenu.add(exitmenu);
	}

}
