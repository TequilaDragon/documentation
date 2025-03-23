import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class login2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernametextfield;
	private JTextField passtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login2 frame = new login2();
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
	public login2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 10, 389, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		usernametextfield = new JTextField();
		usernametextfield.setBounds(160, 40, 157, 31);
		panel.add(usernametextfield);
		usernametextfield.setColumns(10);
		
		JLabel usernamelabel = new JLabel("Username");
		usernamelabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernamelabel.setBounds(41, 48, 67, 23);
		panel.add(usernamelabel);
		
		passtextField = new JTextField();
		passtextField.setColumns(10);
		passtextField.setBounds(160, 104, 157, 31);
		panel.add(passtextField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(41, 112, 79, 23);
		panel.add(lblPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection qwerty = DriverManager.getConnection("jdbc:mysql://localhost:3307/fds?user=root");

				    PreparedStatement statement2 = qwerty.prepareStatement("SELECT * FROM login WHERE userName = ? AND password007 = ?");
				    statement2.setString(1, usernametextfield.getText());
				    statement2.setString(2, passtextField.getText());
				    ResultSet rs = statement2.executeQuery();

				    if (rs.next()) {
				        System.out.println("User found gago");
				    } else {
				        System.out.println("User does not exist hanapin mo sa kanto");
				    }
				} catch (ClassNotFoundException | SQLException x) {
				    x.printStackTrace();
				}
			}
		});
		loginButton.setBounds(192, 170, 89, 23);
		panel.add(loginButton);
	}
}