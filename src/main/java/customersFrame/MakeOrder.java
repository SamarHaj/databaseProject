package customersFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import loginFrame.LoginScreen;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MakeOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField amount;
	private JTextField date;
	private JTextField number;
	private int i = 0 ; 
	int amount1 = 0 ; 
	private JTextField method;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeOrder frame = new MakeOrder();
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
	public MakeOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow() ; 
					String id1 = model.getValueAt(selectedRowIndex, 0).toString();
					ArrayList<Integer> id = new ArrayList<Integer>(); 
					id.add(Integer.parseInt(id1));
                        amount1 = amount1 +  Integer.parseInt(model.getValueAt(selectedRowIndex, 6).toString());					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
								"S1706578", "lgvoe");
						// here sonoo is database name, root is username and password
						Statement stmt = con.createStatement();
						LoginScreen l = new LoginScreen(); 

						ResultSet rs = stmt.executeQuery("select EID from Employee where UserName = '" +  l.name + "' ;"  );
						
						i++; 
							stmt.executeUpdate("INSERT INTO OrderLine VALUES (" + i + ", "
									+ amount1 + " , " + id + " , " + Integer.parseInt(number.getText())  + ");");
						
					
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
					}
			}
		});
		scrollPane.setBounds(32, 60, 475, 241);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
					"S1706578", "lgvoe");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM products;");
			table.setModel(DbUtils.resultSetToTableModel(rs));

			con.close();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Entered information is not avaliable, please try again");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Entered information is not avaliable, please try again");
		}

		
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(16, 348, 102, 14);
		contentPane.add(lblTotalAmount);
		
		amount = new JTextField();
		amount.setBounds(85, 343, 92, 25);
		contentPane.add(amount);
		amount.setColumns(10);
		
		JLabel lblSelectPaymentMethod = new JLabel("Select payment method cache or shek");
		lblSelectPaymentMethod.setBounds(210, 348, 149, 14);
		contentPane.add(lblSelectPaymentMethod);
		
		JLabel lblEnterTheDate = new JLabel("Enter the date of payment as dd/mm/yyyy");
		lblEnterTheDate.setBounds(16, 389, 227, 14);
		contentPane.add(lblEnterTheDate);
		
		date = new JTextField();
		date.setBounds(237, 386, 113, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://sweng.bethlehem.edu:33062/S1706578",
							"S1706578", "lgvoe");
					// here sonoo is database name, root is username and password
					Statement stmt = con.createStatement();
					LoginScreen l = new LoginScreen(); 
                    AddCustomer c = new AddCustomer(); 
					
					i++; 
						stmt.executeUpdate("INSERT INTO Orders VALUES (" + number + ", '"
								+ date + "' , " + l.name + " , " + c.num  + ");");
						stmt.executeUpdate("INSERT INTO Bill2Client VALUES ( '" + c.add + "' , '"
								+ amount + "' , '" 	+ method.getText() + "' , " + c.num + " , '" + date  + "');");
					
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Entered value is not acceptable please try again");
				}
				
			}
		});
		btnNewButton.setBounds(362, 385, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSelectOrdersFor = new JLabel("Select orders for this customer");
		lblSelectOrdersFor.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSelectOrdersFor.setBounds(32, 24, 208, 14);
		contentPane.add(lblSelectOrdersFor);
		
		number = new JTextField();
		number.setBounds(85, 312, 86, 20);
		contentPane.add(number);
		number.setColumns(10);
		
		method = new JTextField();
		method.setBounds(397, 345, 86, 20);
		contentPane.add(method);
		method.setColumns(10);
		
		JLabel lblOrderNo = new JLabel("Order No ");
		lblOrderNo.setBounds(32, 315, 46, 14);
		contentPane.add(lblOrderNo);
	}
}
