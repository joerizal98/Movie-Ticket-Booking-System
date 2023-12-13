package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import api.AdminApi;
import api.MemberApi;
import bean.Admin;
import bean.Member;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changepasswordmember {

	private JFrame frmChangePasswordMember;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changepasswordmember window = new changepasswordmember();
					window.frmChangePasswordMember.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public changepasswordmember() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChangePasswordMember = new JFrame();
		frmChangePasswordMember.getContentPane().setBackground(new Color(153, 51, 0));
		frmChangePasswordMember.setTitle("Change Password Member");
		frmChangePasswordMember.setBounds(100, 100, 356, 240);
		frmChangePasswordMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmChangePasswordMember.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmChangePasswordMember.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmChangePasswordMember.setVisible(true);
				}
			}
		});
		mnNewMenu.add(exit);
		frmChangePasswordMember.getContentPane().setLayout(null);
		
		Label label = new Label("Change Password");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(61, 10, 295, 54);
		frmChangePasswordMember.getContentPane().add(label);
		
		JLabel lblNewLabel_1_1 = new JLabel("Existing Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(49, 67, 122, 14);
		frmChangePasswordMember.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(71, 96, 88, 14);
		frmChangePasswordMember.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 93, 72, 20);
		frmChangePasswordMember.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(169, 64, 72, 20);
		frmChangePasswordMember.getContentPane().add(passwordField_1);
		
		JButton btnconfirm = new JButton("CONFIRM");
		btnconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String myPass1=String.valueOf(passwordField.getPassword());
				 String myPass2=String.valueOf(passwordField_1.getPassword());
	               

	                try {
	                	MemberApi api =  new MemberApi();
	                	Member member = new Member();
	                	member.setMemberID(api.getMemberID(myPass1));
	                	int x =api.changePassword(member.getMemberID(), myPass2);
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
		btnconfirm.setBounds(131, 146, 89, 23);
		frmChangePasswordMember.getContentPane().add(btnconfirm);
	}

}
