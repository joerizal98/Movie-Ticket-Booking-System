package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontpage extends JFrame {

	private JFrame frmCinema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontpage window = new frontpage();
					window.frmCinema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frontpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCinema = new JFrame();
		frmCinema.setTitle("Movie Ticket Booking System");
		frmCinema.getContentPane().setBackground(new Color(255, 255, 0));
		frmCinema.setBounds(100, 100, 450, 300);
		frmCinema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCinema.getContentPane().setLayout(null);
		
		JButton regButton = new JButton("REGISTER");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberregister.main(null);
				frmCinema.setVisible(false);
			}
		});
		regButton.setBounds(284, 205, 106, 23);
		frmCinema.getContentPane().add(regButton);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin.main(null);
				frmCinema.setVisible(false);
			}
		});
		loginButton.setBounds(164, 205, 89, 23);
		frmCinema.getContentPane().add(loginButton);
		
		JButton admnButton = new JButton("ADMIN MENU");
		admnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin.main(null);
				frmCinema.setVisible(false);
			}
		});
		admnButton.setBounds(10, 205, 124, 23);
		frmCinema.getContentPane().add(admnButton);
		
		Label label = new Label("WELCOME TO MOVIE TICKET BOOKING SYSTEM");
		label.setFont(new Font("Atma", Font.BOLD | Font.ITALIC, 15));
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(35, 65, 372, 31);
		frmCinema.getContentPane().add(label);
		
		JButton visButton = new JButton("BOOk TICKET AS VISITOR");
		visButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booknonmember.main(null);
				frmCinema.setVisible(false);
			}
		});
		visButton.setBounds(118, 158, 182, 23);
		frmCinema.getContentPane().add(visButton);
		
		JMenuBar menuBar = new JMenuBar();
		frmCinema.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmCinema.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(exitmenu);
	}

	public void frontpage() {
		frmCinema.setVisible(true);
		// TODO Auto-generated method stub
		
	}
}
