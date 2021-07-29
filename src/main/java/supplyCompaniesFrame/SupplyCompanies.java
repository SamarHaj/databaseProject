package supplyCompaniesFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplyCompanies extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyCompanies frame = new SupplyCompanies();
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
	public SupplyCompanies() {
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
		
		JButton button = new JButton("Supply companies");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(0, 356, 168, 37);
		panel.add(button);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(180, 107, 682, 393);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("All", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 76, 548, 281);
		panel_1.add(scrollPane_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(380, 28, 153, 28);
		panel_1.add(textField_2);
		
		JLabel label = new JLabel("Search:");
		label.setBounds(313, 34, 55, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Entries.");
		label_1.setBounds(116, 34, 55, 16);
		panel_1.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(60, 28, 49, 28);
		panel_1.add(textField_3);
		
		JLabel label_2 = new JLabel("Show");
		label_2.setBounds(17, 34, 38, 16);
		panel_1.add(label_2);
		
		JButton btnNewButton_2 = new JButton("Edit Selected Customer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(577, 76, 90, 28);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Selected Customer");
		btnNewButton_3.setBounds(577, 116, 90, 28);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Executed", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(18, 65, 548, 281);
		panel_2.add(scrollPane_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(381, 17, 153, 28);
		panel_2.add(textField_4);
		
		JLabel label_3 = new JLabel("Search:");
		label_3.setBounds(314, 23, 55, 16);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Entries.");
		label_4.setBounds(117, 23, 55, 16);
		panel_2.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(61, 17, 49, 28);
		panel_2.add(textField_5);
		
		JLabel label_5 = new JLabel("Show");
		label_5.setBounds(18, 23, 38, 16);
		panel_2.add(label_5);
		
		JButton btnRemoveSelectedCustomer = new JButton("Remove Selected Customer");
		btnRemoveSelectedCustomer.setBounds(578, 111, 90, 28);
		panel_2.add(btnRemoveSelectedCustomer);
		
		JButton btnEditSelectedCustomer = new JButton("Edit Selected Customer");
		btnEditSelectedCustomer.setBounds(578, 71, 90, 28);
		panel_2.add(btnEditSelectedCustomer);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Draft", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblShow = new JLabel("Show");
		lblShow.setBounds(16, 21, 38, 16);
		panel_3.add(lblShow);
		
		textField = new JTextField();
		textField.setBounds(59, 15, 49, 28);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblEntiers = new JLabel("Entries.");
		lblEntiers.setBounds(115, 21, 55, 16);
		panel_3.add(lblEntiers);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(312, 21, 55, 16);
		panel_3.add(lblSearch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(379, 15, 153, 28);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 63, 548, 281);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRemoveSelectedCustomer_1 = new JButton("Remove Selected Customer");
		btnRemoveSelectedCustomer_1.setBounds(575, 108, 90, 28);
		panel_3.add(btnRemoveSelectedCustomer_1);
		
		JButton btnEditSelectedCutomer = new JButton("Edit Selected Cutomer");
		btnEditSelectedCutomer.setBounds(575, 68, 90, 28);
		panel_3.add(btnEditSelectedCutomer);
		
		JButton btnNewButton_5 = new JButton("Show Orders For Selected Customer");
		btnNewButton_5.setBounds(576, 147, 90, 28);
		panel_3.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Customers");
		lblNewLabel.setBounds(180, 48, 183, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("+ New Supply Company");
		btnNewButton_1.setBounds(548, 48, 275, 38);
		contentPane.add(btnNewButton_1);
	}
}
