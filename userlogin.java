package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class userlogin extends JFrame {

	private JFrame frmMemberLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin window = new userlogin();
					window.frmMemberLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMemberLogin = new JFrame();
		frmMemberLogin.setTitle("Login as user");
		frmMemberLogin.setBounds(100, 100, 261, 285);
		frmMemberLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMemberLogin.getContentPane().setLayout(null);
		
		Label label = new Label("Member ID");
		label.setBounds(32, 33, 62, 22);
		frmMemberLogin.getContentPane().add(label);
		
		TextField textField = new TextField();
		textField.setBounds(100, 33, 113, 22);
		frmMemberLogin.getContentPane().add(textField);
		
		Label label_1 = new Label("Password");
		label_1.setBounds(32, 74, 62, 22);
		frmMemberLogin.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 74, 113, 20);
		frmMemberLogin.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(70, 102, 89, 23);
		frmMemberLogin.getContentPane().add(btnLogin);
		
		Label label_2 = new Label("Not an existing member? Register now");
		label_2.setBounds(10, 162, 219, 22);
		frmMemberLogin.getContentPane().add(label_2);
		
		JButton btnRegisterAsNew = new JButton("Register as new member");
		btnRegisterAsNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberregister.main(null);
				frmMemberLogin.setVisible(false);
			}
		});
		btnRegisterAsNew.setBounds(26, 190, 182, 23);
		frmMemberLogin.getContentPane().add(btnRegisterAsNew);
		
		JButton btnchangepassword = new JButton("Change Password");
		btnchangepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changepasswordmember.main(null);
				frmMemberLogin.setVisible(false);
			}
		});
		btnchangepassword.setBounds(32, 136, 182, 23);
		frmMemberLogin.getContentPane().add(btnchangepassword);
		
		JMenuBar menuBar = new JMenuBar();
		frmMemberLogin.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmMemberLogin.setVisible(true);
				}
				
			}
		});
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmMemberLogin.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		mnNewMenu.add(exitmenu);
	}

}
