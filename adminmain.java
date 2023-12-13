package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class adminmain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmain window = new adminmain();
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
	public adminmain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 51));
		frame.setBounds(100, 100, 388, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Movie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmovie.main(null);
				frame.setVisible(false);
			}
			
		});
		btnNewButton.setBounds(117, 81, 133, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hall");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminhall.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(117, 115, 133, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Showtime");
		btnNewButton_2.setBounds(117, 183, 133, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Booked Ticket");
		btnNewButton_3.setBounds(117, 149, 133, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblAdminPage = new JLabel("Admin Page");
		lblAdminPage.setForeground(new Color(255, 255, 255));
		lblAdminPage.setFont(new Font("Dialog", Font.BOLD, 21));
		lblAdminPage.setBackground(SystemColor.menu);
		lblAdminPage.setBounds(126, 11, 153, 43);
		frame.getContentPane().add(lblAdminPage);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Main Menu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frame.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frame.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
