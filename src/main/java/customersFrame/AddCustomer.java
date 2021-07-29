package customersFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField address;
	private JTextField number;
	public static int num ;
	public static String add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCusomerName = new JLabel("Customer Name ");
		lblCusomerName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblCusomerName.setBounds(21, 134, 107, 14);
		contentPane.add(lblCusomerName);
		
		name = new JTextField();
		name.setBounds(142, 128, 122, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnAddOrderFor = new JButton("Add Order for this customer");
		btnAddOrderFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeOrder order = new MakeOrder(); 
			    order.main(null);
			}
		});
		btnAddOrderFor.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnAddOrderFor.setBounds(131, 338, 210, 23);
		contentPane.add(btnAddOrderFor);
		
		phone = new JTextField();
		phone.setBounds(142, 172, 122, 28);
		contentPane.add(phone);
		phone.setColumns(10);
		
		email = new JTextField();
		email.setBounds(142, 217, 122, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		address = new JTextField();
		address.setBounds(142, 259, 122, 28);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel phobe = new JLabel("phone");
		phobe.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		phobe.setBounds(73, 178, 55, 16);
		contentPane.add(phobe);
		
		JLabel lblNewLabel_1 = new JLabel("email");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(73, 223, 55, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("address");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_2.setBounds(73, 265, 55, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					// here sonoo is database name, root is username and password
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select CID from Client");
					int count = 0;
					while (rs.next()) {
						if (rs.getInt(1) == Integer.parseInt(number.getText())) {
							count++;
						}
					}
					if (count == 0) {
						stmt.executeUpdate("INSERT INTO Client VALUES (" + Integer.parseInt(number.getText()) + ", '"
								+ name.getText() + "', '" + phone.getText() + "', '" + email.getText() +  "', '" + address.getText() + "');");
						number.setText("");
						name.setText("");
						phone.setText("");
						email.setText("");
						 num = Integer.parseInt(number.getText()) ;
						 add = address.getText();
						 
					} else {
						JOptionPane.showMessageDialog(null,
								"Entered customer number is not avaliable please try again");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

			}
		});
		btnNewButton.setBounds(294, 259, 90, 28);
		contentPane.add(btnNewButton);
		
		number = new JTextField();
		number.setBounds(142, 81, 122, 28);
		contentPane.add(number);
		number.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("Customer Number");
		lblCustomerNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblCustomerNumber.setBounds(21, 86, 122, 16);
		contentPane.add(lblCustomerNumber);
	}
}
