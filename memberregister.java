package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import api.AdminApi;
import api.MemberApi;
import api.VisitorApi;
import bean.Admin;
import bean.Member;
import bean.Visitor;

public class memberregister extends JFrame {

	private JFrame memberreg;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memberregister window = new memberregister();
					window.memberreg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public memberregister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		memberreg = new JFrame();
		memberreg.setTitle("New Member Registration");
		memberreg.getContentPane().setBackground(new Color(0, 102, 204));
		memberreg.setBounds(100, 100, 439, 298);
		memberreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberreg.getContentPane().setLayout(null);
		
		Label label = new Label("New Member Registration");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(51, 29, 319, 54);
		memberreg.getContentPane().add(label);
		
		Label label_2 = new Label("Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(131, 89, 47, 22);
		memberreg.getContentPane().add(label_2);
		
		Label label_1 = new Label("Phone Number");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(84, 130, 90, 22);
		memberreg.getContentPane().add(label_1);
		
		TextField name1 = new TextField();
		name1.setBounds(176, 89, 113, 22);
		memberreg.getContentPane().add(name1);
		
		TextField pnum = new TextField();
		pnum.setBounds(176, 130, 113, 22);
		memberreg.getContentPane().add(pnum);
		
		password = new JPasswordField();
		password.setBounds(177, 168, 113, 20);
		memberreg.getContentPane().add(password);
		
		
		
		JButton regg = new JButton("REGISTER");
		regg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PhoneNum = pnum.getText();
				 String myPassd=String.valueOf(password.getPassword());
				 String name = name1.getText();
				   try {
					   MemberApi mapi = new MemberApi();
					   Visitor visitor = new Visitor();
					   VisitorApi vapi = new VisitorApi();
					   visitor.setName(name);
					   boolean x = vapi.checkUsername(name);
					   
					   if(x==true) {
					       Member member = new Member(visitor.getName(), PhoneNum, myPassd);
					       int c = mapi.insertMember(member);
	                        if (c == 0) {
	                            JOptionPane.showMessageDialog(regg, "This is already exist");
	                            //duplicate when register cause adminID is unique
	                       } else {
	                            JOptionPane.showMessageDialog(regg,
	                            "Welcome Your account is sucessfully created");
	                      }
	                    }
					   else {
						   vapi.insertVisitor(visitor);
						   Member member = new Member(visitor.getName(), PhoneNum, myPassd);
						   int c = mapi.insertMember(member);
	                       if (c == 0) {
	                            JOptionPane.showMessageDialog(regg, "This is already exist");
	                            //duplicate when register cause adminID is unique
	                       } 
	                       else {
	                            JOptionPane.showMessageDialog(regg,
	                            "Welcome Your account is sucessfully created");
	                       }
					   }
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }    
			}
		});
		regg.setBounds(148, 207, 105, 23);
		memberreg.getContentPane().add(regg);
		
		Label label_1_1 = new Label("Password");
		label_1_1.setForeground(new Color(255, 255, 255));
		label_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1_1.setBounds(109, 168, 62, 22);
		memberreg.getContentPane().add(label_1_1);
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		memberreg.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					memberreg.setVisible(true);
				}
				
			}
		});
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				memberreg.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		mnNewMenu.add(exitmenu);
	}
}
