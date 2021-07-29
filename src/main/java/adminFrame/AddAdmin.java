package adminFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import appointmentFrame.AddA;
import appointmentFrame.Appointment;
import loginFrame.LoginScreen;

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

public class AddAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField phone;
	private JTextField city;
	private JTextField firstName;
	public static int num ;
	public static String add;
	private JTextField number;
	private JTextField street;
	private JTextField house;
	private JTextField user;
	private JTextField pass;
	static AddAdmin  frame ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AddAdmin();
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
	public AddAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		phone = new JTextField();
		phone.setBounds(383, 144, 122, 28);
		contentPane.add(phone);
		phone.setColumns(10);
		
		city = new JTextField();
		city.setBounds(309, 183, 122, 27);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel phobe = new JLabel("Phone Number");
		phobe.setBounds(267, 148, 185, 16);
		phobe.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(phobe);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setBounds(267, 186, 55, 16);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		firstName = new JTextField();
		firstName.setBounds(373, 107, 122, 28);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("First Name");
		lblCustomerNumber.setBounds(267, 112, 122, 16);
		lblCustomerNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblCustomerNumber);
		
		JLabel lblNewLabel = new JLabel("Add Admin");
		lblNewLabel.setBounds(267, 21, 240, 28);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		number = new JTextField();
		number.setBounds(373, 67, 122, 28);
		contentPane.add(number);
		number.setColumns(10);
		
		JLabel lblPatientNumber = new JLabel("Admin Number");
		lblPatientNumber.setBounds(267, 72, 159, 16);
		lblPatientNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblPatientNumber);
		
		street = new JTextField();
		street.setBounds(615, 219, 122, 28);
		contentPane.add(street);
		street.setColumns(10);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setBounds(526, 224, 113, 16);
		lblStreetName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblStreetName);
		
		house = new JTextField();
		house.setBounds(384, 216, 122, 28);
		contentPane.add(house);
		house.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House Number");
		lblHouseNumber.setBounds(267, 221, 94, 16);
		lblHouseNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblHouseNumber);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 0, 168, 576);
		contentPane.add(panel);
		
		JButton button = new JButton("Appointments");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Appointment a = new Appointment(); 
				a.main(null);
				frame.setVisible(false);
			}
		});
		button.setBounds(0, 225, 168, 45);
		panel.add(button);
		
		JButton button_1 = new JButton("Add Appointment");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(0, 289, 168, 45);
		panel.add(button_1);
		
		user = new JTextField();
		user.setBounds(355, 296, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(568, 296, 86, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(267, 299, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_3.setBounds(490, 297, 68, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					// here sonoo is database name, root is username and password
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT ID FROM Secretary;");

							int count1 = 0;
							while (rs.next()) {
								if (rs.getInt(1) == Integer.parseInt(number.getText())) {
									count1++;
								}
							}
							 rs = stmt.executeQuery("SELECT User FROM Secretary;");
							 int count2 = 0;
								while (rs.next()) {
									if (rs.getString(1) == user.getText()) {
										count2++;
									}
								}
							if (count1 == 0 && count2 == 0) {
								stmt.executeUpdate("INSERT INTO Secretary VALUES (" + Integer.parseInt(number.getText()) + ", '"
										+ firstName.getText() +  "', '" + user.getText() + "', '"
										+ pass.getText() + "' , '" + phone.getText() + "' , '" + city.getText() + "' , '" + street.getText() + "' , '" + house.getText() + "' );");
							
								city.setText("");
								firstName.setText("");
								user.setText("");
								pass.setText("");


								phone.setText("");
								house.setText("");
								street.setText("");
								
								
								
						

					} else {
						JOptionPane.showMessageDialog(null,
								"Entered number is not avaliable please try again");

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnNewButton.setBounds(373, 358, 256, 23);
		contentPane.add(btnNewButton);
	}
}
