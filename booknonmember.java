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
import javax.swing.JComboBox;
import javax.swing.JTextField;

import api.MovieApi;
import bean.Movie;
import bean.ShowTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class booknonmember {

	private JFrame frmNonMemberBook;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booknonmember window = new booknonmember();
					window.frmNonMemberBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public booknonmember() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNonMemberBook = new JFrame();
		frmNonMemberBook.getContentPane().setBackground(new Color(0, 0, 51));
		frmNonMemberBook.setTitle("Non Member Book");
		frmNonMemberBook.setBounds(100, 100, 450, 327);
		frmNonMemberBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNonMemberBook.getContentPane().setLayout(null);
		
		Label label_1_2 = new Label("WELCOME");
		label_1_2.setForeground(new Color(255, 255, 255));
		label_1_2.setBounds(10, 10, 89, 22);
		frmNonMemberBook.getContentPane().add(label_1_2);
		
		Label label = new Label("Movie Details");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 21));
		label.setBounds(135, 0, 142, 54);
		frmNonMemberBook.getContentPane().add(label);
		
		JComboBox kombo = new JComboBox();
		kombo.setBounds(155, 60, 226, 22);
		frmNonMemberBook.getContentPane().add(kombo);
		
		Label label_1 = new Label("Select Movie");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(74, 60, 75, 22);
		frmNonMemberBook.getContentPane().add(label_1);
		
		Label label_1_1 = new Label("Select Date");
		label_1_1.setForeground(new Color(255, 255, 255));
		label_1_1.setBounds(74, 93, 75, 22);
		frmNonMemberBook.getContentPane().add(label_1_1);
		
		JComboBox kombo2 = new JComboBox();
		kombo2.setBounds(155, 93, 226, 22);
		frmNonMemberBook.getContentPane().add(kombo2);
		
		Label label_1_1_1 = new Label("Select Time");
		label_1_1_1.setForeground(new Color(255, 255, 255));
		label_1_1_1.setBounds(74, 126, 75, 22);
		frmNonMemberBook.getContentPane().add(label_1_1_1);
		
		JComboBox kombo3 = new JComboBox();
		kombo3.setBounds(155, 126, 226, 22);
		frmNonMemberBook.getContentPane().add(kombo3);
		
		Label label_1_1_2 = new Label("Select Seat");
		label_1_1_2.setForeground(new Color(255, 255, 255));
		label_1_1_2.setBounds(74, 159, 75, 22);
		frmNonMemberBook.getContentPane().add(label_1_1_2);
		
		JComboBox kombo4 = new JComboBox();
		kombo4.setBounds(155, 159, 226, 22);
		frmNonMemberBook.getContentPane().add(kombo4);
		
		Label label_1_1_2_1_1 = new Label("Total Price");
		label_1_1_2_1_1.setForeground(new Color(255, 255, 255));
		label_1_1_2_1_1.setBounds(74, 190, 75, 22);
		frmNonMemberBook.getContentPane().add(label_1_1_2_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(155, 192, 86, 20);
		frmNonMemberBook.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(155, 231, 89, 23);
		frmNonMemberBook.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("View Seat Position");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatposition.main(null);
				frmNonMemberBook.setVisible(false);
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(282, 235, 112, 14);
		frmNonMemberBook.getContentPane().add(lblNewLabel);
		
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				MovieApi api2 = new MovieApi();
            	Movie movie = new Movie();
            	ArrayList<Movie>m = new ArrayList<Movie>();
            	m= api2.displayMovie();
            	
            	
            	
            		
            		kombo.addItem(m);
            	
            	
			}catch (Exception exception) {
                exception.printStackTrace();
            }
			}
		});
		refresh.setBounds(298, 22, 89, 23);
		frmNonMemberBook.getContentPane().add(refresh);
		
		JMenuBar menuBar = new JMenuBar();
		frmNonMemberBook.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);
		
		JMenuItem mainmenu = new JMenuItem("Main Menu");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage.main(null);
				frmNonMemberBook.setVisible(false);
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
					frmNonMemberBook.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(exit);
	}
}
