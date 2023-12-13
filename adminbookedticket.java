package guitest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import api.Booked_TicketApi;
import api.HallApi;
import bean.Booked_Ticket;
import bean.Hall;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminbookedticket {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminbookedticket window = new adminbookedticket();
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
	public adminbookedticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookedTicket = new JLabel("Booked Ticket");
		lblBookedTicket.setForeground(Color.BLACK);
		lblBookedTicket.setFont(new Font("Dialog", Font.PLAIN, 21));
		lblBookedTicket.setBackground(SystemColor.menu);
		lblBookedTicket.setBounds(137, 5, 199, 43);
		frame.getContentPane().add(lblBookedTicket);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 50, 270, 142);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton view = new JButton("View");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		view.setBounds(54, 203, 89, 23);
		frame.getContentPane().add(view);
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                try {
                	Booked_TicketApi api =  new Booked_TicketApi();
                	Booked_Ticket book = new Booked_Ticket();
                	String sid = JOptionPane.showInputDialog(InsertButton, "Enter ShowID");
                	String name = JOptionPane.showInputDialog(InsertButton, "Enter Name");
                	String stid = JOptionPane.showInputDialog(InsertButton, "Enter SeatID");
                	api.insertBooking(book);
                	JOptionPane.showMessageDialog(InsertButton,
	                            "Succesfully Inserted");
             		
                //	int i= Integer.parseInt(hallidd);
                //	boolean x =api.checkHall(i);
                //	if(x==false) {
                //		hall.setHallID(i);
                //		hall.assignSeatID(hall.getHallID());
                //		api.insertHall_Seat(hall);
                //		 JOptionPane.showMessageDialog(InsertButton,
 	            //                "Succesfully Inserted");
                //		
                //	}
                //	else {
	             //           JOptionPane.showMessageDialog(InsertButton,
	           //                 "Cannot insert, Hall ID already exist");
             //   }
                	//api.setName(Name);
                	//admin.setPassword(myPass);
                	//boolean x =api.checkUsername(admin);
                   
                    	
        				
                   
                    
                   
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				
			}
		});
		InsertButton.setBounds(261, 203, 89, 23);
		frame.getContentPane().add(InsertButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frame.setVisible(false);
			}
		});
		mnNewMenu.add(mainmenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frame.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
