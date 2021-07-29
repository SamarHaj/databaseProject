package edu.bu.databaseProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginFrame.LoginScreen;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class MainScreen extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(0, 0, 168, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnNewButton.setBounds(0, 80, 168, 45);
		panel.add(btnNewButton);
		
		JButton btnSales = new JButton("Sales Order");
		btnSales.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnSales.setBounds(0, 162, 168, 45);
		panel.add(btnSales);
		
		JButton button = new JButton("Customers");
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button.setBounds(0, 230, 168, 37);
		panel.add(button);
		
		JButton button_1 = new JButton("Inventory");
		button_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_1.setBounds(0, 291, 168, 37);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Supply companies");
		button_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_2.setBounds(0, 353, 168, 37);
		panel.add(button_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(180, 125, 404, 375);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("This Month", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Last 6 Months", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Financial Year", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 206, 209));
		panel_4.setBounds(596, 91, 279, 409);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 58, 267, 305);
		panel_4.add(scrollPane);
		
		JPanel panel_6 = new JPanel();
		scrollPane.setViewportView(panel_6);
		panel_6.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Recent Activites");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_3.setBounds(91, 16, 170, 30);
		panel_4.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("View All Activites");
		btnNewButton_1.setBounds(66, 375, 165, 28);
		panel_4.add(btnNewButton_1);
		LoginScreen l = new LoginScreen(); 
		String name1 = "Hello " + l.name;
		JLabel lblNewLabel = new JLabel(name1);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel.setBounds(201, 6, 284, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your last login was on 02/09/2019 10:00PM. ");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setBounds(201, 41, 339, 25);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 206, 209));
		panel_5.setBounds(179, 79, 195, 34);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Income and Expense Overview");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		panel_5.add(lblNewLabel_2);
	}
}
