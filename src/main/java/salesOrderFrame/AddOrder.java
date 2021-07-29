package salesOrderFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AddOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrder frame = new AddOrder();
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
	public AddOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterCustomerNumbe = new JLabel("Enter Customer Numbe OR Select Customers from Table Below. ");
		lblEnterCustomerNumbe.setBounds(35, 22, 409, 14);
		contentPane.add(lblEnterCustomerNumbe);
		
		textField = new JTextField();
		textField.setBounds(126, 41, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("Customer Number");
		lblCustomerNumber.setBounds(35, 44, 86, 14);
		contentPane.add(lblCustomerNumber);
		
		JLabel lblNewLabel = new JLabel("Search For The Customer");
		lblNewLabel.setBounds(35, 64, 230, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 100, 457, 179);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblOr_1 = new JLabel("OR");
		lblOr_1.setBounds(315, 47, 46, 14);
		contentPane.add(lblOr_1);
		
		JButton btnAddNew = new JButton("+ Add New Customer");
		btnAddNew.setBounds(349, 40, 143, 23);
		contentPane.add(btnAddNew);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 66, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSelectProducts = new JButton("Select products for this order ");
		btnSelectProducts.setBounds(35, 301, 196, 23);
		btnSelectProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnSelectProducts);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(35, 340, 102, 14);
		contentPane.add(lblTotalAmount);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 337, 92, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSelectPaymentMethod = new JLabel("Select payment method");
		lblSelectPaymentMethod.setBounds(212, 342, 149, 14);
		contentPane.add(lblSelectPaymentMethod);
		
		JRadioButton rdbtnSh = new JRadioButton("sh");
		rdbtnSh.setBounds(383, 336, 61, 23);
		contentPane.add(rdbtnSh);
		
		JRadioButton rdbtnCache = new JRadioButton("cache");
		rdbtnCache.setBounds(456, 336, 61, 23);
		contentPane.add(rdbtnCache);
		
		JLabel lblEnterTheDate = new JLabel("Enter the date of payment as dd/mm/yyyy");
		lblEnterTheDate.setBounds(38, 373, 227, 14);
		contentPane.add(lblEnterTheDate);
		
		textField_3 = new JTextField();
		textField_3.setBounds(259, 370, 113, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(406, 369, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(474, 425, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save as Draft");
		btnNewButton_2.setBounds(309, 422, 158, 28);
		contentPane.add(btnNewButton_2);
	}
}
