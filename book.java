package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;

public class book extends javax.swing.JFrame {
	


	private JFrame mdetail;
	private JTextField ticketnum;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book window = new book();
					window.mdetail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public book() {
		initialize();
		
		
	}
	

	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mdetail = new JFrame();
		mdetail.getContentPane().setBackground(new Color(0, 0, 51));
		mdetail.setTitle("Member Book");
		mdetail.setBounds(100, 100, 450, 336);
		mdetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mdetail.getContentPane().setLayout(null);
		
		Label label = new Label("Movie Details");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 21));
		label.setBounds(135, 10, 142, 54);
		mdetail.getContentPane().add(label);
		
		JComboBox kombo = new JComboBox();
		kombo.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mousePressed(MouseEvent e) {
				 try{
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/oop_project";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            Statement stat = con.createStatement();    
			            String selectQuery="select * from movie";
			            ResultSet rs=stat.executeQuery(selectQuery);
			            while(rs.next())
			            {
			                kombo.addItem(rs.getString("movieName"));
			                
			                
			            }
			                    
			        
			        }
			        catch(Exception e1)
			        {
			            System.out.println(e1);
			        }
			}
		});
		kombo.setBounds(155, 70, 226, 22);
		mdetail.getContentPane().add(kombo);
		
		Label label_1 = new Label("Select Movie");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(74, 70, 75, 22);
		mdetail.getContentPane().add(label_1);
		
		Label label_1_1 = new Label("Select Date");
		label_1_1.setForeground(new Color(255, 255, 255));
		label_1_1.setBounds(74, 103, 75, 22);
		mdetail.getContentPane().add(label_1_1);
		
		JComboBox kombo2 = new JComboBox();
		kombo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 try{
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/oop_project";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            Statement stat = con.createStatement();    
			            String selectQuery="select * from showtime";
			            ResultSet rs=stat.executeQuery(selectQuery);
			            while(rs.next())
			            {
			                kombo2.addItem(rs.getDate("day"));
			                
			                
			            }
			                    
			        
			        }
			        catch(Exception e1)
			        {
			            System.out.println(e1);
			        }
			}
		});
		kombo2.setBounds(155, 103, 226, 22);
		mdetail.getContentPane().add(kombo2);
		
		Label label_1_1_1 = new Label("Select Time");
		label_1_1_1.setForeground(new Color(255, 255, 255));
		label_1_1_1.setBounds(74, 136, 75, 22);
		mdetail.getContentPane().add(label_1_1_1);
		
		JComboBox kombo3 = new JComboBox();
		kombo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 try{
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/oop_project";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            Statement stat = con.createStatement();    
			            String selectQuery="select * from showtime";
			            ResultSet rs=stat.executeQuery(selectQuery);
			            while(rs.next())
			            {
			                kombo3.addItem(rs.getTime("time"));
			                
			                
			            }
			                    
			        
			        }
			        catch(Exception e1)
			        {
			            System.out.println(e1);
			        }
				
			}
		});
		kombo3.setBounds(155, 136, 226, 22);
		mdetail.getContentPane().add(kombo3);
		
		Label label_1_1_2 = new Label("Select Seat");
		label_1_1_2.setForeground(new Color(255, 255, 255));
		label_1_1_2.setBounds(74, 169, 75, 22);
		mdetail.getContentPane().add(label_1_1_2);
		
		JComboBox kombo4 = new JComboBox();
		kombo4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 try{
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/oop_project";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            Statement stat = con.createStatement();    
			            String selectQuery="select * from seat";
			            ResultSet rs=stat.executeQuery(selectQuery);
			            while(rs.next())
			            {
			                kombo4.addItem(rs.getString("seatID"));
			                
			                
			            }
			                    
			        
			        }
			        catch(Exception e1)
			        {
			            System.out.println(e1);
			        }
			}
		});
		kombo4.setBounds(155, 169, 226, 22);
		mdetail.getContentPane().add(kombo4);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(155, 241, 89, 23);
		mdetail.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("View Seat Position");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatposition.main(null);
				mdetail.setVisible(false);
			}
		});
		lblNewLabel.setBounds(282, 245, 112, 14);
		mdetail.getContentPane().add(lblNewLabel);
		
		Label label_1_2 = new Label("Welcome \"user\"");
		label_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1_2.setForeground(new Color(255, 255, 255));
		label_1_2.setBounds(10, 10, 101, 22);
		mdetail.getContentPane().add(label_1_2);
		
		Label TotalPrice = new Label("Total Price");
		TotalPrice.setForeground(new Color(255, 255, 255));
		TotalPrice.setBounds(74, 200, 75, 22);
		mdetail.getContentPane().add(TotalPrice);
		
		ticketnum = new JTextField();
		ticketnum.setBounds(155, 202, 86, 20);
		mdetail.getContentPane().add(ticketnum);
		ticketnum.setColumns(10);
		
		JButton refresh = new JButton("REFRESH");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
			            Class.forName("com.mysql.jdbc.Driver");
			            String databaseURL = "jdbc:mysql://localhost:3306/oop_project";
			            Connection con = DriverManager.getConnection(databaseURL, "root", "");
			            Statement stat = con.createStatement();    
			            String selectQuery="select * from seat";
			            ResultSet rs=stat.executeQuery(selectQuery);
			            while(rs.next())
			            {
			                kombo4.addItem(rs.getString("seatID"));
			                
			                
			            }
			                    
			        
			        }
			        catch(Exception e1)
			        {
			            System.out.println(e1);
			        }
				
				
			}
		});
		refresh.setBounds(292, 23, 89, 23);
		mdetail.getContentPane().add(refresh);
		
		JMenuBar menuBar = new JMenuBar();
		mdetail.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				mdetail.setVisible(false);
			}
			
		});
		mnNewMenu.add(mainmenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem exitmenu = new JMenuItem("Exit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					mdetail.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(exitmenu);
	}
}
