package loginFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import appointmentFrame.Appointment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {
	

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField  pass;
	public static int name ;
	static LoginScreen frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/frame_00_delay-0.2s.gif")).getImage();

		lblNewLabel.setIcon(new ImageIcon(img));
		//lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(91, 109, 447, 117);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(116, 210, 358, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 38, 86, 23);
		panel.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBackground(Color.WHITE);
		user.setBounds(128, 36, 156, 28);
		panel.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 82, 86, 14);
		panel.add(lblNewLabel_2);
		
		pass = new JPasswordField();
		pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				Image img = new ImageIcon(this.getClass().getResource("/ezgif.com-gif-maker (3).gif"))
						.getImage();

				lblNewLabel.setIcon(new ImageIcon(img));
			}
		});
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				Image img = new ImageIcon(this.getClass().getResource("/ezgif.com-gif-maker (4).gif")).getImage();

				lblNewLabel.setIcon(new ImageIcon(img));
				
			}
		});
		pass.setBackground(Color.WHITE);
		pass.setBounds(128, 76, 156, 28);
		panel.add(pass);
		pass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					
					Statement stmt = con.createStatement();
					
					ResultSet rs = stmt.executeQuery("SELECT * FROM Secretary WHERE User = '" + user.getText() + "' AND Password = '" + pass.getText() + "';");
					String password = null ; 
					String user1 = null ; 
					while (rs.next()) {

					name = rs.getInt(1);
					user1 = rs.getString(3);

					password = rs.getString(4);
 
					}
					


					if(user1 == user.getText() && password == pass.getText()) {
					
					Appointment a = new Appointment();
					a.main(null);
					frame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "invalid login details");

					}
					
                      
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "invalid login details");

				}
				
				
				
			
		}});
		btnLogin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnLogin.setBackground(new Color(176, 224, 230));
		btnLogin.setBounds(150, 154, 108, 32);
		panel.add(btnLogin);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.setBackground(Color.WHITE);
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShowPassword.isSelected()) {
					pass.setEchoChar((char)0);
					Image img = new ImageIcon(this.getClass().getResource("/ezgif.com-gif-maker (4).gif")).getImage();

					lblNewLabel.setIcon(new ImageIcon(img));
					
				}else {
					pass.setEchoChar('*');
					Image img = new ImageIcon(this.getClass().getResource("/ezgif.com-gif-maker (3).gif"))
							.getImage();

					lblNewLabel.setIcon(new ImageIcon(img));

				}
			}
		});
		chckbxShowPassword.setBounds(126, 116, 145, 18);
		panel.add(chckbxShowPassword);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/m.gif")).getImage();

		lblNewLabel_3.setIcon(new ImageIcon(img1));
		lblNewLabel_3.setBounds(0, 0, 606, 438);
		contentPane.add(lblNewLabel_3);
		
	}
}
