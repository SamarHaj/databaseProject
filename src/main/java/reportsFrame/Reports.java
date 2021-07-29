package reportsFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.bu.databaseProject.MainScreen;
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

public class Reports extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	public Reports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 168, 500);
		panel.setBackground(new Color(72, 209, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBounds(0, 80, 168, 45);
		panel.add(btnNewButton);
		
		JButton btnSales = new JButton("Sales Order");
		btnSales.setBounds(0, 162, 168, 45);
		panel.add(btnSales);
		
		JButton btnNewButton_4 = new JButton("Customers");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnNewButton_4.setBounds(0, 233, 168, 37);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Inventory");
		btnNewButton_6.setBounds(0, 294, 168, 37);
		panel.add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("Customers");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblNewLabel.setBounds(222, 33, 183, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(180, 150, 487, 350);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel label = new JLabel("Search:");
		label.setBounds(178, 104, 55, 16);
		contentPane.add(label);
		
		search = new JTextField();
		search.setBounds(243, 98, 153, 28);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(406, 98, 90, 28);
		contentPane.add(btnSearch);
		
		JButton btnNewButton_2 = new JButton("Edit Selected Customer");
		btnNewButton_2.setBounds(679, 155, 188, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Selected Customer");
		btnNewButton_3.setBounds(679, 196, 188, 28);
		contentPane.add(btnNewButton_3);
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://sweng.bethlehem.edu:33062/S1706578","S1706578","lgvoe");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Client");  

			table_1.setModel(DbUtils.resultSetToTableModel(rs));

			con.close(); 

			
              
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "invalid login details");

		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "invalid login details");

		}
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
					
			
						stmt.executeUpdate("DELETE FROM Client WHERE CID = " + id + " ;");
						con.close(); 
						JOptionPane.showMessageDialog(null, "Record removed successfully");


					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

				
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow() ; 
				String id = model.getValueAt(selectedRowIndex, 0).toString();
				String name = model.getValueAt(selectedRowIndex, 1).toString();
				String phone = model.getValueAt(selectedRowIndex, 2).toString();
				String email = model.getValueAt(selectedRowIndex, 3).toString();
				String address = model.getValueAt(selectedRowIndex, 4).toString();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					Statement stmt = con.createStatement();
					
			
						stmt.executeUpdate("UPDATE Client SET Name = '" + name +"', Phone = '" + phone +"' , Email = '" + email  + "' , ShopesAddress = '" + address + "' WHERE CID = " + Integer.parseInt(id) + ";");
						con.close(); 
						JOptionPane.showMessageDialog(null, "Record edited successfully");


					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

				

			
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM Client WHERE Name = '" + search.getText() + "' ;");
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();  

					
                      
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				}
				
			}
		});
	}
}
