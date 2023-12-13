package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import javax.swing.JPasswordField;

import api.AdminApi;
import bean.Admin;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class adminlogin extends JFrame {

	private JFrame frmAdminMenu;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin window = new adminlogin();
					window.frmAdminMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminMenu = new JFrame();
		frmAdminMenu.setTitle("Login as admin");
		frmAdminMenu.setBounds(100, 100, 262, 319);
		frmAdminMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register as new admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminregister.main(null);
				frmAdminMenu.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(37, 224, 172, 23);
		frmAdminMenu.getContentPane().add(btnNewButton);
		
		TextField name = new TextField();
		name.setBounds(95, 35, 113, 22);
		frmAdminMenu.getContentPane().add(name);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
				 String myPass=String.valueOf(password.getPassword());
	               

	                try {
	                	AdminApi api =  new AdminApi();
	                	Admin admin = new Admin();
	                	admin.setName(Name);
	                	admin.setPassword(myPass);
	                	boolean x =api.checkUsername(admin);
	                    if (x == true) {
	                        JOptionPane.showMessageDialog(btnLogin, "Welcome");
	                        adminmain.main(null);
	        				frmAdminMenu.setVisible(false);
	                    } else {
	                        JOptionPane.showMessageDialog(btnLogin,
	                            "Your name or password in incorrent");
	                    }
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
		btnLogin.setBounds(77, 120, 89, 23);
		frmAdminMenu.getContentPane().add(btnLogin);
		
		Label label = new Label("Name");
		label.setBounds(27, 35, 62, 22);
		frmAdminMenu.getContentPane().add(label);
		
		Label label_1 = new Label("Password");
		label_1.setBounds(27, 76, 62, 22);
		frmAdminMenu.getContentPane().add(label_1);
		
		Label label_2 = new Label("Not an existing admin? Register now");
		label_2.setBounds(27, 196, 219, 22);
		frmAdminMenu.getContentPane().add(label_2);
		
		password = new JPasswordField();
		password.setBounds(95, 76, 113, 20);
		frmAdminMenu.getContentPane().add(password);
		
		JButton btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepassword.main(null);
				frmAdminMenu.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(53, 153, 156, 23);
		frmAdminMenu.getContentPane().add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		frmAdminMenu.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmAdminMenu.setVisible(false);
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
					frmAdminMenu.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(exitmenu);
	}
}
