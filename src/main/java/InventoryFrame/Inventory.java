package InventoryFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class Inventory extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
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
	public Inventory() {
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
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setBounds(180, 48, 183, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("+ New Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct p = new AddProduct();
				p.main(null);
			}
		});
		btnNewButton_1.setBounds(548, 48, 275, 38);
		contentPane.add(btnNewButton_1);
		
		search = new JTextField();
		search.setBounds(274, 113, 153, 28);
		contentPane.add(search);
		search.setColumns(10);
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://sweng.bethlehem.edu:33062/S1706578","S1706578","lgvoe");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from products");  

			table.setModel(DbUtils.resultSetToTableModel(rs));

			con.close(); 

			
              
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "invalid login details");

		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "invalid login details");

		}
		
		
		JButton btnNewButton_2 = new JButton("Edit Selected Product");
		btnNewButton_2.setBounds(677, 145, 169, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Selected Product");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow() ; 
				String id = model.getValueAt(selectedRowIndex, 0).toString();
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					Statement stmt = con.createStatement();
					
			
						stmt.executeUpdate("DELETE FROM products WHERE PID = " + id + " ;");
						con.close(); 
						JOptionPane.showMessageDialog(null, "Record removed successfully");


					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}


			}
		});
		btnNewButton_3.setBounds(677, 185, 169, 28);
		contentPane.add(btnNewButton_3);
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setBounds(196, 120, 66, 14);
		contentPane.add(lblProductName);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE Name = '" + search.getText() + "' ;");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();  

					
                      
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				}
			}
		});
		btnSearch.setBounds(482, 116, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 167, 452, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow() ; 
				String id = model.getValueAt(selectedRowIndex, 0).toString();
				String name = model.getValueAt(selectedRowIndex, 1).toString();
				String sec = model.getValueAt(selectedRowIndex, 2).toString();
				String size = model.getValueAt(selectedRowIndex, 3).toString();
				String qua = model.getValueAt(selectedRowIndex, 4).toString();
				String price = model.getValueAt(selectedRowIndex, 5).toString();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					Statement stmt = con.createStatement();
					
			
						stmt.executeUpdate("UPDATE Client SET Name = '" + name  +"', Section = '" + sec +"' , Size = '" + size  + "' , Quantity = '" + qua  + "' , price = '" + Integer.parseInt(price) + "' WHERE PID = " + Integer.parseInt(id) + ";");
						con.close(); 
						JOptionPane.showMessageDialog(null, "Record edited successfully");


					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

				
			}
		});
	}
}
