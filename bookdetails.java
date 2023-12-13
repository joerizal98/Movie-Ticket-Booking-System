package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

public class bookdetails extends JFrame {

	private JFrame frmBookingDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookdetails window = new bookdetails();
					window.frmBookingDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bookdetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookingDetails = new JFrame();
		frmBookingDetails.getContentPane().setBackground(new Color(153, 153, 255));
		frmBookingDetails.setTitle("Booking Details");
		frmBookingDetails.setBounds(100, 100, 432, 300);
		frmBookingDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookingDetails.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Details");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBackground(SystemColor.control);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 21));
		lblNewLabel.setBounds(119, 24, 199, 43);
		frmBookingDetails.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Movie Name:");
		lblNewLabel_1.setBounds(97, 100, 75, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\"Database Field\"");
		lblNewLabel_1_1.setBounds(182, 100, 101, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date:");
		lblNewLabel_1_2.setBounds(97, 121, 75, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\"Database Field\"");
		lblNewLabel_1_1_1.setBounds(182, 121, 101, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Time:");
		lblNewLabel_1_2_1.setBounds(97, 138, 75, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\"Database Field\"");
		lblNewLabel_1_1_1_1.setBounds(182, 138, 101, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(61, 217, 89, 23);
		frmBookingDetails.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book.main(null);
				frmBookingDetails.setVisible(false);
			}
		});
		btnCancel.setBounds(257, 217, 89, 23);
		frmBookingDetails.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Hall:");
		lblNewLabel_1_2_1_1.setBounds(97, 155, 75, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\"Database Field\"");
		lblNewLabel_1_1_1_1_1.setBounds(182, 155, 101, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Seat:");
		lblNewLabel_1_2_1_1_1.setBounds(97, 172, 75, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("\"Database Field\"");
		lblNewLabel_1_1_1_1_1_1.setBounds(182, 172, 101, 14);
		frmBookingDetails.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(72, 65, 247, 140);
		frmBookingDetails.getContentPane().add(horizontalBox);
		
		JMenuBar menuBar = new JMenuBar();
		frmBookingDetails.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmanu = new JMenuItem("Main Menu");
		mainmanu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmBookingDetails.setVisible(false);
			}
		});
		mnNewMenu.add(mainmanu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmBookingDetails.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(exitmenu);
	}
}
