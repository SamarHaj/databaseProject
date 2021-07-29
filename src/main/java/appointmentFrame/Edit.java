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

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTextField lastName;
	private JTextField phone;
	private JTextField city;
	private JTextField firstName;
	public static int num ;
	public static String add;
	int id1 ; 
	private JTextField date;
	private JTextField time;
	private JTextField duration;
	private JTextField street;
	private JTextField house;
	static Edit frame ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Edit();
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
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 577);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCusomerName = new JLabel("Last Name");
		lblCusomerName.setBounds(498, 69, 107, 14);
		lblCusomerName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblCusomerName);
		
		lastName = new JTextField();
		lastName.setBounds(577, 64, 122, 28);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(360, 102, 122, 28);
		contentPane.add(phone);
		phone.setColumns(10);
		
		city = new JTextField();
		city.setBounds(303, 141, 122, 28);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel phobe = new JLabel("Phone Number");
		phobe.setBounds(261, 106, 122, 16);
		phobe.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(phobe);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setBounds(261, 143, 55, 16);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setBounds(360, 424, 204, 28);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					// here sonoo is database name, root is username and password
					Statement stmt = con.createStatement();
					Appointment a = new Appointment();
					LoginScreen l = new LoginScreen(); 

				
                      
					 ResultSet rs = stmt.executeQuery("select AppointementTime from Appoinment;");
							 int count2 = 0;
								while (rs.next()) {
									if (rs.getString(1) == time.getText()) {
										count2++;
									}
								}
							if (count2 == 0) {
								
								Appointment a1 = new Appointment();

								stmt.executeUpdate("UPDATE Appoinment SET AppointementTime  = '" + time.getText() + "', Date = '" + date.getText() +  "' , AppointementDuration = '" + duration.getText() + "' WHERE ID =" + a1.id  + ";");
								stmt.executeUpdate("UPDATE Patient SET firstName  = '" + firstName.getText() + "', lastName = '" + lastName.getText() +  "' , phone  = '" + phone.getText() + "', City = '" + city.getText() +  "' , street  = '" + street.getText() +  "' , HouseNo  = '" + house.getText() +"' WHERE ID =" + id1  + ";");

								time.setText("");
								date.setText("");
								duration.setText("");
								city.setText("");
								firstName.setText("");
								lastName.setText("");

								phone.setText("");
								house.setText("");
								street.setText("");
								frame.setVisible(false);

								

					} else {
						JOptionPane.showMessageDialog(null,
								"Entered customer number is not avaliable please try again");

					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}

			}
		});
		contentPane.add(btnNewButton);
		
		firstName = new JTextField();
		firstName.setBounds(350, 64, 122, 28);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("First Name");
		lblCustomerNumber.setBounds(261, 69, 122, 16);
		lblCustomerNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblCustomerNumber);
		
		JLabel lblNewLabel = new JLabel("Add patient information");
		lblNewLabel.setBounds(261, 21, 240, 28);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblAddAppointmentInformation = new JLabel("Add appointment information");
		lblAddAppointmentInformation.setBounds(263, 248, 281, 16);
		lblAddAppointmentInformation.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		contentPane.add(lblAddAppointmentInformation);
		
		date = new JTextField();
		date.setBounds(324, 286, 122, 28);
		contentPane.add(date);
		date.setColumns(10);
		
		time = new JTextField();
		time.setBounds(324, 325, 122, 28);
		contentPane.add(time);
		time.setColumns(10);
		
		duration = new JTextField();
		duration.setBounds(324, 364, 59, 28);
		contentPane.add(duration);
		duration.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDate.setBounds(261, 292, 55, 16);
		contentPane.add(lblDate);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDuration.setBounds(261, 372, 55, 16);
		contentPane.add(lblDuration);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(261, 335, 55, 16);
		contentPane.add(lblNewLabel_1);
		
		street = new JTextField();
		street.setBounds(350, 186, 122, 28);
		contentPane.add(street);
		street.setColumns(10);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setBounds(261, 190, 141, 16);
		lblStreetName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblStreetName);
		
		house = new JTextField();
		house.setBounds(594, 186, 122, 28);
		contentPane.add(house);
		house.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House Number");
		lblHouseNumber.setBounds(494, 190, 94, 16);
		lblHouseNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		contentPane.add(lblHouseNumber);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(393, 370, 55, 16);
		contentPane.add(lblMin);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
					"S1706578", "lgvoe");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			Appointment a = new Appointment();
			LoginScreen l = new LoginScreen(); 

			String id = a.id ; 
			
			ResultSet rs=stmt.executeQuery("select Appoinment.ID , Patient.ID ,  firstName , lastName , phone , City , Street , HouseNo , Date, AppointementTime, AppointementDuration from Patient, Appoinment where Patient.ID = Appoinment.patientID and Appoinment.ID = " + Integer.parseInt(id) + " ;");  
			while (rs.next()) {

            int i = rs.getInt(1);
			id1 =  rs.getInt(2);
  			firstName.setText(rs.getString(3));
			lastName.setText(rs.getString(4));
			phone.setText(rs.getString(5));
            city.setText(rs.getString(6));

			street.setText(rs.getString(7));
			house.setText(rs.getString(8));



             
				date.setText(rs.getString(9));

				time.setText(rs.getString(10));
				duration.setText(rs.getString(11));
			}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
	}

		
		JLabel lblEnterDateAs = new JLabel("Enter Date as dd\\mm\\yyyy");
		lblEnterDateAs.setBounds(423, 286, 182, 16);
		contentPane.add(lblEnterDateAs);
		
		JLabel lblEnterTimeAs = new JLabel("Enter Time as hh:mm");
		lblEnterTimeAs.setBounds(456, 331, 147, 16);
		contentPane.add(lblEnterTimeAs);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 0, 168, 539);
		contentPane.add(panel);
		
		JButton button = new JButton("Appointments");
		button.setBounds(0, 225, 168, 45);
		panel.add(button);
		
		JButton button_1 = new JButton("Add Appointment");
		button_1.setBounds(0, 289, 168, 45);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Add Admin");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_2.setBounds(0, 345, 168, 35);
		panel.add(button_2);
	}
}
