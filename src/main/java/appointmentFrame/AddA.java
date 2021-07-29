package appointmentFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class AddA extends JFrame {

	private JPanel contentPane;
	private JTextField lastName;
	private JTextField phone;
	private JTextField city;
	private JTextField firstName;
	public static int num ;
	public static String add;
	private JTextField number;
	private JTextField date;
	private JTextField time;
	private JTextField duration;
	private JTextField street;
	private JTextField house;
	private JTextField aNumber;
	static AddA frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AddA();
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
	public AddA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 598);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCusomerName = new JLabel("Last Name");
		lblCusomerName.setBounds(267, 146, 107, 14);
		lblCusomerName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblCusomerName);
		
		lastName = new JTextField();
		lastName.setBounds(373, 140, 122, 28);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(373, 175, 122, 28);
		contentPane.add(phone);
		phone.setColumns(10);
		
		city = new JTextField();
		city.setBounds(309, 215, 122, 28);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel phobe = new JLabel("Phone Number");
		phobe.setBounds(267, 184, 185, 16);
		phobe.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(phobe);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setBounds(267, 220, 55, 16);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(396, 526, 294, 28);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					// here sonoo is database name, root is username and password
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select ID from Patient;");
					int count = 0;
					while (rs.next()) {
						if (rs.getInt(1) == Integer.parseInt(aNumber.getText())) {
							count++;
						}
					}
					LoginScreen l = new LoginScreen(); 
					if (count == 0) {
						stmt.executeUpdate("INSERT INTO Patient VALUES ('" + firstName.getText() + "', '" + lastName.getText() + "', '" + phone.getText() + "', "
								+ Integer.parseInt(aNumber.getText())  + " , '" + city.getText() + "' , '" + street.getText() + "' , '" + house.getText() + "' );");
				
						 rs = stmt.executeQuery("select ID from Appoinment;");

							int count1 = 0;
							while (rs.next()) {
								if (rs.getInt(1) == Integer.parseInt(number.getText())) {
									count1++;
								}
							}
							 rs = stmt.executeQuery("select AppointementTime from Appoinment;");
							 int count2 = 0;
								while (rs.next()) {
									if (rs.getString(1) == time.getText()) {
										count2++;
									}
								}
							if (count1 == 0 && count2 == 0) {
								stmt.executeUpdate("INSERT INTO Appoinment VALUES (" + Integer.parseInt(number.getText()) + ", '"
										+ time.getText() + "', '" + Integer.parseInt(aNumber.getText())  + "', '" + date.getText() + "', "
										+ l.name + " , " + duration.getText() + ");");
								number.setText("");
								time.setText("");
								date.setText("");
								duration.setText("");
								aNumber.setText("");
								city.setText("");
								firstName.setText("");
								lastName.setText("");

								phone.setText("");
								house.setText("");
								street.setText("");
								
								
						

					} else {
						JOptionPane.showMessageDialog(null,
								"Entered number is not avaliable please try again");

					}
				}} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

			}
		});
		contentPane.add(btnNewButton);
		
		firstName = new JTextField();
		firstName.setBounds(373, 107, 122, 28);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("First Name");
		lblCustomerNumber.setBounds(267, 112, 122, 16);
		lblCustomerNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblCustomerNumber);
		
		JLabel lblNewLabel = new JLabel("Add patient information");
		lblNewLabel.setBounds(267, 21, 240, 28);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblAddAppointmentInformation = new JLabel("Add appointment information");
		lblAddAppointmentInformation.setBounds(286, 312, 281, 16);
		lblAddAppointmentInformation.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		contentPane.add(lblAddAppointmentInformation);
		
		number = new JTextField();
		number.setBounds(373, 67, 122, 28);
		contentPane.add(number);
		number.setColumns(10);
		
		JLabel lblPatientNumber = new JLabel("Patient Number");
		lblPatientNumber.setBounds(267, 72, 159, 16);
		lblPatientNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblPatientNumber);
		
		date = new JTextField();
		date.setBounds(407, 390, 122, 28);
		contentPane.add(date);
		date.setColumns(10);
		
		time = new JTextField();
		time.setBounds(407, 430, 122, 28);
		contentPane.add(time);
		time.setColumns(10);
		
		duration = new JTextField();
		duration.setBounds(407, 470, 122, 28);
		contentPane.add(duration);
		duration.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDate.setBounds(267, 396, 55, 16);
		contentPane.add(lblDate);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDuration.setBounds(267, 476, 55, 16);
		contentPane.add(lblDuration);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(267, 442, 55, 16);
		contentPane.add(lblNewLabel_1);
		
		street = new JTextField();
		street.setBounds(615, 251, 122, 28);
		contentPane.add(street);
		street.setColumns(10);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setBounds(526, 256, 113, 16);
		lblStreetName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblStreetName);
		
		house = new JTextField();
		house.setBounds(384, 248, 122, 28);
		contentPane.add(house);
		house.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House Number");
		lblHouseNumber.setBounds(267, 253, 94, 16);
		lblHouseNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblHouseNumber);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(564, 470, 55, 16);
		contentPane.add(lblMin);
		
		JLabel lblNewLabel_3 = new JLabel("Appointment Number");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_3.setBounds(267, 356, 164, 16);
		contentPane.add(lblNewLabel_3);
		
		aNumber = new JTextField();
		aNumber.setBounds(407, 350, 122, 28);
		contentPane.add(aNumber);
		aNumber.setColumns(10);
		
		JLabel lblEnterDateAs = new JLabel("Enter Date as dd\\mm\\yyyy");
		lblEnterDateAs.setBounds(555, 396, 182, 16);
		contentPane.add(lblEnterDateAs);
		
		JLabel lblEnterTimeAs = new JLabel("Enter Time as hh:mm");
		lblEnterTimeAs.setBounds(554, 436, 147, 16);
		contentPane.add(lblEnterTimeAs);
		
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
		
		JButton button_2 = new JButton("Add Admin");
		button_2.setBounds(0, 302, 168, 35);
		panel.add(button_2);
	}
}
