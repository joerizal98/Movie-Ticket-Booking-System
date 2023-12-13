package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JPasswordField;

import api.AdminApi;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import bean.Admin;
import api.AdminApi;
import db.DatabaseConnection;

public class adminregister extends JFrame {

	private JFrame frmNewAdminRegistration;
	private JPasswordField passwordd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminregister window = new adminregister();
					window.frmNewAdminRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminregister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAdminRegistration = new JFrame();
		frmNewAdminRegistration.getContentPane().setBackground(new Color(0, 204, 51));
		frmNewAdminRegistration.setTitle("New Admin Registration");
		frmNewAdminRegistration.setBounds(100, 100, 450, 251);
		frmNewAdminRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewAdminRegistration.getContentPane().setLayout(null);
		
		Label label = new Label("New Admin Registration");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(75, 10, 295, 54);
		frmNewAdminRegistration.getContentPane().add(label);
		
		Label label_1 = new Label("Password");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(116, 111, 62, 22);
		frmNewAdminRegistration.getContentPane().add(label_1);
		
		passwordd = new JPasswordField();
		passwordd.setBounds(184, 111, 113, 20);
		frmNewAdminRegistration.getContentPane().add(passwordd);
		
		Label label_2 = new Label("Name");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(116, 70, 62, 22);
		frmNewAdminRegistration.getContentPane().add(label_2);
		
		TextField namee = new TextField();
		namee.setBounds(184, 70, 113, 22);
		frmNewAdminRegistration.getContentPane().add(namee);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name = namee.getText();
				 String myPass=String.valueOf(passwordd.getPassword());
	               

	                try {
	                	AdminApi api =  new AdminApi();
	                	Admin admin = new Admin();
	                	admin.setName(Name);
	                	admin.setPassword(myPass);
	                	int x =api.insertAdmin(admin);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnRegister, "This is alredy exist");
	                        //duplicate when register cause adminID is unique
	                    } else {
	                        JOptionPane.showMessageDialog(btnRegister,
	                            "Welcome Your account is sucessfully created");
	                    }
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
		btnRegister.setBounds(154, 154, 105, 23);
		frmNewAdminRegistration.getContentPane().add(btnRegister);
		
		JMenuBar menuBar = new JMenuBar();
		frmNewAdminRegistration.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmNewAdminRegistration.setVisible(false);
			}
		});
		
		mnNewMenu.add(mainmenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmNewAdminRegistration.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(exitmenu);
	}

}
