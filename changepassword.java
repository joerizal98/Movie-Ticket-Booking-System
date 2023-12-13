package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import api.AdminApi;
import bean.Admin;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.Color;

public class changepassword {

	private JFrame frmChangePassword;
	private JPasswordField newpass;
	private JPasswordField epass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changepassword window = new changepassword();
					window.frmChangePassword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public changepassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChangePassword = new JFrame();
		frmChangePassword.getContentPane().setBackground(new Color(51, 102, 102));
		frmChangePassword.getContentPane().setForeground(new Color(51, 102, 102));
		frmChangePassword.setTitle("Change Password Admin");
		frmChangePassword.setBounds(100, 100, 349, 240);
		frmChangePassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangePassword.getContentPane().setLayout(null);
		
		JButton btnconfirm = new JButton("CONFIRM");
		btnconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String myPass1=String.valueOf(epass.getPassword());
				 String myPass2=String.valueOf(newpass.getPassword());
	               

	                try {
	                	AdminApi api =  new AdminApi();
	                	Admin admin = new Admin();
	                	admin.setAdminID(api.getAdminID(myPass1));
	                	int x =api.changePassword(admin.getAdminID(), myPass2);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnconfirm, "Please enter a valid password");
	                    } else {
	                        JOptionPane.showMessageDialog(btnconfirm,
	                            "Your password is succesfully changed!! ");
	                    }
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				
				
			}
		});
		btnconfirm.setBounds(119, 146, 89, 23);
		frmChangePassword.getContentPane().add(btnconfirm);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setBounds(59, 96, 88, 14);
		frmChangePassword.getContentPane().add(lblNewLabel_1);
		
		newpass = new JPasswordField();
		newpass.setBounds(157, 93, 72, 20);
		frmChangePassword.getContentPane().add(newpass);
		
		JLabel lblNewLabel_1_1 = new JLabel("Existing Password");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setBounds(37, 67, 122, 14);
		frmChangePassword.getContentPane().add(lblNewLabel_1_1);
		
		epass = new JPasswordField();
		epass.setBounds(157, 64, 72, 20);
		frmChangePassword.getContentPane().add(epass);
		
		Label label = new Label("Change Password");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(49, 10, 295, 54);
		frmChangePassword.getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		frmChangePassword.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmChangePassword.setVisible(true);
				}
				
			}
		});
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmChangePassword.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		mnNewMenu.add(exitmenu);
	}
}
