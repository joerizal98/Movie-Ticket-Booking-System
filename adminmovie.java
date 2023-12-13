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
import javax.swing.table.DefaultTableModel;

import api.HallApi;
import api.MovieApi;
import bean.Hall;
import bean.Movie;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class adminmovie {

	private JFrame frmAdminMovie;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmovie window = new adminmovie();
					window.frmAdminMovie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminmovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminMovie = new JFrame();
		frmAdminMovie.setTitle("Admin Movie");
		frmAdminMovie.setBounds(100, 100, 523, 380);
		frmAdminMovie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminMovie.getContentPane().setLayout(null);
		
		JLabel lblMovie = new JLabel("Movie");
		lblMovie.setForeground(Color.BLACK);
		lblMovie.setFont(new Font("Dialog", Font.BOLD, 21));
		lblMovie.setBackground(SystemColor.menu);
		lblMovie.setBounds(219, 11, 199, 43);
		frmAdminMovie.getContentPane().add(lblMovie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 65, 416, 157);
		frmAdminMovie.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie ID", "Movie Name", "Type", "Price"
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
	                	MovieApi api =  new MovieApi();
	                	Movie movie = new Movie();
	                	ArrayList<Movie>hall1=api.displayMovie();
	                	for(Movie h: hall1)
	                	{
	                		
	                		
	                		h1 = String.valueOf(h.getMovieID());
	                		h2 = String.valueOf(h.getMovieName());
	                		h3 = String.valueOf(h.getType());
	                		h4 = String.valueOf(h.getPrice());
	                	    //h2 = h.getNumberOfSeat();
	                		String tbData[]={h1,h2,h3,h4};
	                		tblModel.addRow(tbData);
	                		//tblModel.removeRow(0);
	                	
	                	  
	                	}
	                
	                	
	                	
	                	 
	                	  
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				
			}
		});
		view.setBounds(40, 251, 89, 23);
		frmAdminMovie.getContentPane().add(view);
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
                	MovieApi api =  new MovieApi();
                	Movie movie = new Movie();
                	String name = JOptionPane.showInputDialog(InsertButton, "Enter Movie Name");
                	String type = JOptionPane.showInputDialog(InsertButton, "Enter Movie Type");
                	String price = JOptionPane.showInputDialog(InsertButton, "Enter Movie Price ");
                	
                              	
             movie.setMovieName(name);
             movie.setType(type);
             movie.setPrice(Double.parseDouble(price));
                		api.insertMovie(movie);
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
		InsertButton.setBounds(139, 251, 89, 23);
		frmAdminMovie.getContentPane().add(InsertButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MovieApi api =  new MovieApi();
                	Movie movie = new Movie();
                	String movid = JOptionPane.showInputDialog(DeleteButton, "Enter Movie ID to delete");
                	int i= Integer.parseInt(movid);
                	boolean x =api.checkMovie(i);
                	if(x==true) {
                		api.deleteMovie(i);
                		 JOptionPane.showMessageDialog(DeleteButton,
 	                            "Succesfully Deleted");
                		
                	}
                	else {
	                        JOptionPane.showMessageDialog(DeleteButton,
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
		DeleteButton.setBounds(349, 251, 89, 23);
		frmAdminMovie.getContentPane().add(DeleteButton);
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    try {
	                	MovieApi api =  new MovieApi();
	                	Movie movie = new Movie();
	                	String id = JOptionPane.showInputDialog(UpdateButton, "Enter Movie ID");
	                	int i= Integer.parseInt(id);
	                	boolean x =api.checkMovie(i);
	                	if(x==true) {
	                		String name = JOptionPane.showInputDialog(UpdateButton, "Enter New Movie Name");
		                	String type = JOptionPane.showInputDialog(UpdateButton, "Enter New Movie Type");
		                	String price = JOptionPane.showInputDialog(UpdateButton, "Enter New Movie Price ");
		                	  movie.setMovieName(name);
		     	             movie.setType(type);
		     	             movie.setPrice(Double.parseDouble(price));
		     	             movie.setMovieID(i);
		     	                		api.updateMovie(movie);
		     	                		 JOptionPane.showMessageDialog(UpdateButton,
		     	 	                            "Succesfully Updated");
	                		
	                		
	                	}
	                	else {
	                		JOptionPane.showMessageDialog(UpdateButton,
		                            "Cannot update, movie ID not exist");
	                		
				    }
	                	
	                    
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
			
			
		});
		UpdateButton.setBounds(250, 251, 89, 23);
		frmAdminMovie.getContentPane().add(UpdateButton);
		
		JButton btnViewShowtime = new JButton("View Showtime");
		btnViewShowtime.setBounds(100, 285, 128, 23);
		frmAdminMovie.getContentPane().add(btnViewShowtime);
		
		JButton btnDisplayBooking = new JButton("Display Booking");
		btnDisplayBooking.setBounds(260, 285, 128, 23);
		frmAdminMovie.getContentPane().add(btnDisplayBooking);
		
		JMenuBar menuBar = new JMenuBar();
		frmAdminMovie.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmAdminMovie.setVisible(false);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Admin Menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminmain.main(null);
				frmAdminMovie.setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		mnNewMenu.add(mainmenu);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					frmAdminMovie.setVisible(true);
				}
			}
		});
		mnNewMenu.add(exit);
	}

}
