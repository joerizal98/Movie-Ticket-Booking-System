package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import api.AdminApi;
import api.VisitorApi;
import bean.Admin;
import bean.Visitor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class nonmemberuser {

	private JFrame frmGuestBook;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nonmemberuser window = new nonmemberuser();
					window.frmGuestBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public nonmemberuser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuestBook = new JFrame();
		frmGuestBook.setTitle("Guest Book");
		frmGuestBook.setBounds(100, 100, 406, 273);
		frmGuestBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmGuestBook.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmGuestBook.setVisible(true);
				}
				
			}
		});
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmGuestBook.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		mnNewMenu.add(exitmenu);
		frmGuestBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Your Name To Start Booking");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(64, 45, 273, 19);
		frmGuestBook.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(111, 75, 159, 37);
		frmGuestBook.getContentPane().add(name);
		name.setColumns(10);
		
		JButton confirmbttn = new JButton("CONFIRM");
		confirmbttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
			
				try {
                	VisitorApi api =  new VisitorApi();
                	Visitor visitor = new Visitor();
                	visitor.setName(Name);
                
                	int x =api.insertMember(visitor);
                   
                        JOptionPane.showMessageDialog(confirmbttn, "Welcome, you can start booking now");
                        book.main(null);
        				frmGuestBook.setVisible(false);
                   
                   
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
	                
			}
		});
		confirmbttn.setBounds(91, 155, 89, 23);
		frmGuestBook.getContentPane().add(confirmbttn);
		
		JButton cnclbttn = new JButton("CANCEL");
		cnclbttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmGuestBook.setVisible(false);
			}
		});
		cnclbttn.setBounds(212, 155, 89, 23);
		frmGuestBook.getContentPane().add(cnclbttn);
	}
}
