package placement_cell;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame{

	private JFrame frame;
	private JTextField name;
	private JLabel lblNewLabel_2;
	private JTextField email;
	private JLabel lblNewLabel_3;
	private JTextField phone;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField password;
	private JTextArea address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		//frame = new JFrame();
		frame.setBounds(100, 100, 627, 733);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(187, 33, 225, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(82, 151, 145, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(313, 151, 205, 33);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setBounds(82, 203, 145, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(313, 203, 205, 33);
		frame.getContentPane().add(email);
		
		lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_3.setBounds(82, 259, 145, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(313, 259, 205, 33);
		frame.getContentPane().add(phone);
		
		lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_4.setBounds(82, 319, 145, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_5.setBounds(82, 436, 145, 33);
		frame.getContentPane().add(lblNewLabel_5);
		
//		address textArea = new JTextArea();
//		textArea.setBounds(313, 326, 205, 78);
//		frame.getContentPane().add(address);
		
		password = new JPasswordField();
		password.setBounds(313, 436, 205, 33);
		frame.getContentPane().add(password);
		
		address = new JTextArea();
		address.setBounds(313, 319, 205, 84);
		frame.getContentPane().add(address);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(s_id) from students";
					
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into students(s_id,s_name,s_email,s_phone,s_address,s_pwd) values(?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1,newuid);
					ps.setString(2, name.getText());
					ps.setString(3, email.getText());
					ps.setLong(4,Long.parseLong(phone.getText()));
					ps.setString(5,address.getText());
					ps.setString(6, pass);
					try {
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Data inserted succesfully");
							Home h = new Home();
							h.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Data Insertion Failed");
						}
					}catch(Exception e1) {
						System.out.println(e);
					}
				}catch(Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNewButton.setBounds(242, 536, 112, 33);
		frame.getContentPane().add(btnNewButton);
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
