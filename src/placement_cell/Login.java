package placement_cell;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField email;
	private JPasswordField password;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 1147, 571);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(457, 23, 217, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(285, 152, 187, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(598, 150, 217, 36);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(285, 210, 187, 34);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(598, 210, 217, 34);
		frame.getContentPane().add(password);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query1="select * from students where s_email='"+email.getText()+"' and s_pwd = '"+password.getText()+"' ";
					System.out.println(query1);
					ResultSet rs = stmt.executeQuery(query1);
					
					if(rs.next())
					{
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Login Succesfull");
						Student_home sh = new Student_home(rs.getInt("s_id"));
						sh.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Login Failed");
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(505, 318, 102, 27);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}

}
