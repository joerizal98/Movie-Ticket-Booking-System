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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import api.HallApi;
import api.MovieApi;
import api.ShowTimeApi;
import bean.Hall;
import bean.Movie;
import bean.ShowTime;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class adminshowtime {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminshowtime window = new adminshowtime();
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
	public adminshowtime() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShowtime = new JLabel("Showtime");
		lblShowtime.setForeground(Color.BLACK);
		lblShowtime.setFont(new Font("Dialog", Font.PLAIN, 21));
		lblShowtime.setBackground(SystemColor.menu);
		lblShowtime.setBounds(173, 11, 199, 43);
		frame.getContentPane().add(lblShowtime);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 56, 398, 142);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Show ID", "Day", "Time", "Name", "Hall ID","Available"
			}
		));
		scrollPane.setViewportView(table);
		
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
	                	String h3 = null;
	                	String h4 = null;
	                	String h5 = null;
	                	String h6 = null;
                		ShowTimeApi api =  new ShowTimeApi();
                		ShowTime st = new ShowTime();
                		ArrayList<ShowTime> list = new ArrayList<ShowTime>();
                		int s;
                		list=api.displayShowTime();
                		

	                	for(ShowTime h: list)
	                	{	
		                    JDialog diag = new JDialog();
		                    diag.pack();
		                    diag.setVisible(false);
	                		
	                		h1 = String.valueOf(h.getShowID());
	                		h2 = String.valueOf(h.getDay());
	                		h3 = String.valueOf(h.getTime());
	                		h4 = String.valueOf(h.getMovie().getMovieName());
	                	    h5 = String.valueOf(h.getHall().getHallID());
	                	    s = api.availabeSeat(h);
	                	    h6 = String.valueOf(s);
	                	    //h2 = h.getNumberOfSeat();
	                		String tbData[]={h1,h2,h3,h4,h5,h6};
	                		tblModel.addRow(tbData);  
	                	}       
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				
				
				
			}
		});
		view.setBounds(35, 214, 89, 23);
		frame.getContentPane().add(view);
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 ShowTimeApi api =  new ShowTimeApi();
             		ShowTime st = new ShowTime();
             		Movie movie = new Movie();
             		Hall hall = new Hall();
	                	String day = JOptionPane.showInputDialog(InsertButton, "Enter Day");
	                	String time = JOptionPane.showInputDialog(InsertButton, "Enter Time");
	                	String movieid = JOptionPane.showInputDialog(InsertButton, "Enter MovieID ");
	                	String hallid = JOptionPane.showInputDialog(InsertButton, "Enter HallID ");
	                	
	                              	
	             st.setDay(LocalDate.parse(day));
	             st.setTime(LocalTime.parse(time));
	             movie.setMovieID(Integer.parseInt(movieid));
	             hall.setHallID(Integer.parseInt(hallid));
	             st.setMovie(movie);
	             st.setHall(hall);
	                		api.insertShowTime(st);
	                		 JOptionPane.showMessageDialog(InsertButton,
	 	                            "Succesfully Inserted");
	                		
	                
	                	//api.setName(Name);
	                	//admin.setPassword(myPass);
	                	//boolean x =api.checkUsername(admin);
	                   
	                    	
	        				
	                   
	                    
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
		InsertButton.setBounds(144, 214, 89, 23);
		frame.getContentPane().add(InsertButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 ShowTimeApi api =  new ShowTimeApi();
	                	ShowTime show = new ShowTime();
	                	String sid = JOptionPane.showInputDialog(InsertButton, "Enter Show ID");
	                	int i= Integer.parseInt(sid);
	                	boolean x =api.checkShowTime(i);
	                	if(x==true) {
	                		api.deleteShowTime(i);
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
		DeleteButton.setBounds(357, 214, 89, 23);
		frame.getContentPane().add(DeleteButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 ShowTimeApi api = new ShowTimeApi();
					 ShowTime show = new ShowTime();
					 Movie movie = new Movie();
					 Hall hall = new Hall();
	                	String id = JOptionPane.showInputDialog(btnUpdate, "Enter ShowTime ID");
	                	int i= Integer.parseInt(id);
	                	boolean x =api.checkShowTime(i);
	                	if(x==true) {
	                		String day = JOptionPane.showInputDialog(btnUpdate, "Enter New Day");
		                	String time = JOptionPane.showInputDialog(btnUpdate, "Enter New Time");
		                	String mid = JOptionPane.showInputDialog(btnUpdate, "Enter New MovieID ");
		                	String hid = JOptionPane.showInputDialog(btnUpdate, "Enter New HallID ");
		                	show.setShowID(i);
		                	show.setDay(LocalDate.parse(day));
		                	show.setTime(LocalTime.parse(time));
		                	movie.setMovieID(Integer.parseInt(mid));
		                	hall.setHallID(Integer.parseInt(hid));
		                	 show.setMovie(movie);
		                	 show.setHall(hall);
		                	   api.updateShowTime(show);
		                	   JOptionPane.showMessageDialog(btnUpdate,
    	 	                            "Succesfully Updated");
		                	 }
		     	                		 
	                		
	                		
	                	
	                	else {
	                		JOptionPane.showMessageDialog(btnUpdate,
		                            "Cannot update, movie ID not exist");
	                		
				    }
	                	
	                    
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				
			}
		});
		btnUpdate.setBounds(250, 214, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
	}

}
