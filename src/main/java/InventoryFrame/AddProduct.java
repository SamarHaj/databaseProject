package InventoryFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField section;
	private JTextField size;
	private JTextField quantity;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(84, 33, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(84, 66, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		section = new JTextField();
		section.setBounds(84, 153, 86, 20);
		contentPane.add(section);
		section.setColumns(10);
		
		size = new JTextField();
		size.setBounds(84, 195, 86, 20);
		contentPane.add(size);
		size.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(209, 33, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(229, 211, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					// here sonoo is database name, root is username and password
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select productCode from products;");
					int count = 0;
					while (rs.next()) {
						if (rs.getInt(1) == Integer.parseInt(id.getText())) {
							count++;
						}
					}
					if (count == 0) {
						stmt.executeUpdate("INSERT INTO products VALUES (" + Integer.parseInt(id.getText()) + ", '"
								+ name.getText() +"', '"
								+ section.getText() + "', '" + size.getText() + "' , "
								+ Integer.parseInt(price.getText()) + ");");
						id.setText("");
						name.setText("");
						quantity.setText("");
						section.setText("");
						size.setText("");
						price.setText("");


					} else {
						JOptionPane.showMessageDialog(null, "Entered code is not avaliable please try again");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}
			}
		});
		contentPane.add(btnNewButton);
		
		price = new JTextField();
		price.setBounds(209, 77, 86, 20);
		contentPane.add(price);
		price.setColumns(10);
	}

}
