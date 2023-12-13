package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import api.AdminApi;
import api.HallApi;
import bean.Admin;
import bean.Hall;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class adminhall {

	private JFrame frame;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminhall window = new adminhall();
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
	public adminhall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 405, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(151, 97, 110, -37);
		frame.getContentPane().add(list);
		
		JButton view = new JButton("View");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
        		while(tblModel.getRowCount() > 0)
        		{
        		    tblModel.removeRow(0);
        		}

	                try {
	                	
	                	
	                	//int h1 = 0;
	                	//int h2 = 0;
	                	String h1 = null;
	                	String h2 = null;
	                	HallApi api =  new HallApi();
	                	Hall hall = new Hall();
	                	ArrayList<Hall>hall1=api.displayHall();
	                	for(Hall h: hall1)
	                	{
	                		
	                		
	                		h1 = String.valueOf(h.getHallID());
	                		h2 = String.valueOf(h.getNumberOfSeat());
	                	    //h2 = h.getNumberOfSeat();
	                		String tbData[]={h1,h2};
	                		tblModel.addRow(tbData);
	                		//tblModel.removeRow(0);
	                	
	                	  
	                	}
	                
	                	
	                	
	                	 
	                	  
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
		view.setBounds(22, 214, 89, 23);
		frame.getContentPane().add(view);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 56, 270, 142);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hall ID", "Number Of Seat"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblDisplayHall = new JLabel("Display Hall");
		lblDisplayHall.setForeground(Color.BLACK);
		lblDisplayHall.setFont(new Font("Dialog", Font.PLAIN, 21));
		lblDisplayHall.setBackground(SystemColor.menu);
		lblDisplayHall.setBounds(130, 11, 199, 43);
		frame.getContentPane().add(lblDisplayHall);
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

                try {
                	HallApi api =  new HallApi();
                	Hall hall = new Hall();
                	String hallidd = JOptionPane.showInputDialog(InsertButton, "Enter Hall ID");
                	int i= Integer.parseInt(hallidd);
                	boolean x =api.checkHall(i);
                	if(x==false) {
                		hall.setHallID(i);
                		hall.assignSeatID(hall.getHallID());
                		api.insertHall_Seat(hall);
                		 JOptionPane.showMessageDialog(InsertButton,
 	                            "Succesfully Inserted");
                		
                	}
                	else {
	                        JOptionPane.showMessageDialog(InsertButton,
	                            "Cannot insert, Hall ID already exist");
                }
                	//api.setName(Name);
                	//admin.setPassword(myPass);
                	//boolean x =api.checkUsername(admin);
                   
                    	
        				
                   
                    
                   
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
			}
		});
		InsertButton.setBounds(138, 214, 89, 23);
		frame.getContentPane().add(InsertButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                	HallApi api =  new HallApi();
	                	Hall hall = new Hall();
	                	String hallidd = JOptionPane.showInputDialog(InsertButton, "Enter Hall ID");
	                	int i= Integer.parseInt(hallidd);
	                	boolean x =api.checkHall(i);
	                	if(x==true) {
	                		api.deleteHall(i);
	                		 JOptionPane.showMessageDialog(InsertButton,
	 	                            "Succesfully Deleted");
	                		
	                	}
	                	else {
		                        JOptionPane.showMessageDialog(InsertButton,
		                            "Cannot delete, Hall ID is not exist");
	                }
	                	//api.setName(Name);
	                	//admin.setPassword(myPass);
	                	//boolean x =api.checkUsername(admin);
	                   
	                    	
	        				
	                   
	                    
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				
				
			}
		});
		DeleteButton.setBounds(250, 214, 89, 23);
		frame.getContentPane().add(DeleteButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Main Menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frame.setVisible(false);
				
			}
		});
		
		JMenuItem adminmenu = new JMenuItem("Admin Menu");
		adminmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmain.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu.add(adminmenu);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frame.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}
