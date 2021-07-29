package appointmentFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adminFrame.AddAdmin;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Appointment extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	public static 	String id ; 
	private JTable table_1;
	static Appointment frame ;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Appointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Appointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 168, 523);
		panel.setBackground(new Color(72, 209, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSales = new JButton("Add Appointment");
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddA a = new AddA();
				a.main(null);
				frame.setVisible(false);
				
			}
		});
		btnSales.setBounds(0, 214, 168, 45);
		panel.add(btnSales);
		
		JButton btnNewButton_4 = new JButton("Add Admin");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdmin a = new AddAdmin();
				a.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(0, 282, 168, 35);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Appointments");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblNewLabel.setBounds(222, 33, 183, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(180, 150, 692, 350);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblPatientName.setBounds(192, 122, 95, 16);
		contentPane.add(lblPatientName);
		
		search = new JTextField();
		search.setBounds(284, 117, 153, 28);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(764, 110, 90, 28);
		contentPane.add(btnSearch);
		
		JButton btnNewButton_2 = new JButton("Edit Selected Appointment");
		btnNewButton_2.setBounds(901, 187, 188, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Selected Appointment");
		btnNewButton_3.setBounds(901, 227, 188, 28);
		contentPane.add(btnNewButton_3);
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://sweng.bethlehem.edu:33062/S1706578","S1706578","lgvoe");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select Appoinment.ID , firstName , lastName , phone , City , Street , HouseNo , Date, AppointementTime, AppointementDuration from Patient, Appoinment where Patient.ID = Appoinment.patientID;");  

			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
		

			con.close(); 

			
              
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "invalid login details");

		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "invalid login details");

		}
		JButton btnNewButton_1 = new JButton("show all appointments");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://sweng.bethlehem.edu:33062/S1706578","S1706578","lgvoe");  
					//here sonoo is database name, root is username and password  
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select Appoinment.ID , firstName , lastName , phone , City , Street , HouseNo , Date, AppointementTime, AppointementDuration from Patient, Appoinment where Patient.ID = Appoinment.patientID;");  

					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				

					con.close(); 

					
		              
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				}
				
				
			}
		});
		btnNewButton_1.setBounds(901, 147, 185, 28);
		contentPane.add(btnNewButton_1);
		
		date = new JTextField();
		date.setBounds(615, 110, 137, 28);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblSearchForAppointments = new JLabel("Search for Appointments by : ");
		lblSearchForAppointments.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSearchForAppointments.setBounds(192, 83, 309, 16);
		contentPane.add(lblSearchForAppointments);
		
		JLabel lblNewLabel_1 = new JLabel("Appointment Date:");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblNewLabel_1.setBounds(468, 110, 177, 28);
		contentPane.add(lblNewLabel_1);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow() ; 
				String id = model.getValueAt(selectedRowIndex, 0).toString();
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					Statement stmt = con.createStatement();
					
			
						stmt.executeUpdate("DELETE FROM Appoinment WHERE ID = " + id + " ;");
						con.close(); 
						JOptionPane.showMessageDialog(null, "Record removed successfully");
						


					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

				
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
			
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow() ; 
				id = model.getValueAt(selectedRowIndex, 0).toString();
			
			
					 
					Edit e = new Edit(); 
					e.main(null); 
			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "no element selected");

					
  				}
			


				

			
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://sweng.bethlehem.edu:33062/S1706578","S1706578","lgvoe");  
					//here sonoo is database name, root is username and password  
					Statement stmt=con.createStatement();  
					if( date.getText().isEmpty()  && search.getText().isEmpty() != true) {
					ResultSet rs=stmt.executeQuery("select Appoinment.ID , firstName , lastName , phone , City , Street , HouseNo , Date, AppointementTime, AppointementDuration from Patient, Appoinment where Patient.ID = Appoinment.patientID and Patient.firstName = '" + search.getText() + "';");  

					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					}else if (date.getText().isEmpty() != true  && search.getText().isEmpty()) {
						ResultSet rs=stmt.executeQuery("select Appoinment.ID , firstName , lastName , phone , City , Street , HouseNo , Date, AppointementTime, AppointementDuration from Patient, Appoinment where Patient.ID = Appoinment.patientID and Date = '" + date.getText() + "';");  

						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if (date.getText().isEmpty() != true  && search.getText().isEmpty() != true) {
						ResultSet rs=stmt.executeQuery("select Appoinment.ID , firstName , lastName , phone , City , Street , HouseNo , Date, AppointementTime, AppointementDuration from Patient, Appoinment where Patient.ID = Appoinment.patientID and Date = '" + date.getText() + "' and Patient.firstName = '" + search.getText() + "';");  

						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					}

					con.close(); 

					
		              
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				}
				
			}
		});
	}
}
