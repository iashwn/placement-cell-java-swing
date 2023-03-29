package placement_cell;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Faculty_home extends JFrame{

	private JFrame frame;
	private Container layeredPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTable table_2;
	private JTextField stud_id;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_4;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int i=0;
				try {
					Faculty_home window = new Faculty_home(i);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	/**
	 * Create the application.
	 * @param i 
	 * @param i 
	 */
	public Faculty_home(int i) {
		initialize();
	}

//	public Faculty_home() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 1367, 758);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FACULTY PANEL");
		lblNewLabel.setBounds(476, 23, 366, 76);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 109, 1308, 525);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Students", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1283, 409);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Name", "Email", "Phone", "Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setBounds(1134, 35, 159, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement st = con.createStatement();
					
					ResultSet rs = st.executeQuery("select s_id,s_name,s_email,s_phone,s_address from students order by s_id");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("All Students");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_8.setBounds(10, 10, 371, 59);
		panel.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Attendance", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 91, 883, 397);
		panel_2.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Name", "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Day 8", "Day 9", "Day 10"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(102);
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblNewLabel_2 = new JLabel("Mark Present");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(1000, 108, 196, 36);
		panel_2.add(lblNewLabel_2);
		
		stud_id = new JTextField();
		stud_id.setBounds(1054, 154, 239, 36);
		panel_2.add(stud_id);
		stud_id.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(1054, 200, 239, 38);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Student ID");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(903, 154, 167, 36);
		panel_2.add(lblNewLabel_2_1);
		
		JButton btnNewButton_3 = new JButton("Mark Present");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String jc = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
					int k = Integer.parseInt(jc);
					
					String sql = "update students set d"+jc+"='Present' where s_id="+stud_id.getText();
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}catch(Exception e2) {
					System.out.println(e);
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3.setBounds(980, 260, 152, 36);
		panel_2.add(btnNewButton_3);
		
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Day");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(903, 200, 167, 36);
		panel_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("ATTENDANCE");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.BOLD, 36));
		lblNewLabel_2_3.setBounds(10, 10, 389, 71);
		panel_2.add(lblNewLabel_2_3);
		
		JButton btnNewButton_3_1 = new JButton("Mark Absent");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String jc = (String)comboBox.getItemAt(comboBox.getSelectedIndex());
					int k = Integer.parseInt(jc);
					
					String sql = "update students set d"+jc+"='Absent' where s_id="+stud_id.getText();
					System.out.println(sql);
					stmt.executeUpdate(sql);
				}catch(Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_1.setBounds(1142, 260, 137, 36);
		panel_2.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Refresh");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement st3 = con.createStatement();
					
					ResultSet rs2 = st3.executeQuery("select s_id,s_name,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10 from students order by s_id");
					table_2.setModel(DbUtils.resultSetToTableModel(rs2));
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_3_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_2.setBounds(741, 45, 152, 36);
		panel_2.add(btnNewButton_3_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Companies", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Company Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(151, 362, 206, 38);
		panel_5.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Company ID", "Company Name"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(97);
		table_1.setBounds(10, 44, 312, 177);
		panel_5.add(table_1);
		
		textField = new JTextField();
		textField.setBounds(390, 362, 257, 38);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(c_id) from company";
					
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into company values(?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newuid);
					ps.setString(2, textField.getText());
//					ps.setString(3, email.getText());
//					ps.setLong(4,Long.parseLong(phone.getText()));
//					ps.setString(5,address.getText());
//					ps.setString(6, pass);
					//System.out.print(pass);
					try {
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Company added succesfully");
							Faculty_home fh = new Faculty_home(rs.getInt("f_id"));
							fh.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}catch(Exception e1) {
						System.out.println(e);
					}
				}catch(Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnNewButton_1.setBounds(323, 434, 141, 38);
		panel_5.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add new company");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(286, 289, 206, 38);
		panel_5.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("All companies");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 10, 113, 30);
		panel_5.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement st2 = con.createStatement();
					
					ResultSet rs2 = st2.executeQuery("select * from company order by c_id");
					table_1.setModel(DbUtils.resultSetToTableModel(rs2));
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_2.setBounds(131, 18, 85, 21);
		panel_5.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Interviews", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 57, 668, 370);
		panel_3.add(scrollPane_3);
		
		table_4 = new JTable();
		scrollPane_3.setViewportView(table_4);
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sl No", "Company", "Post", "Salary", "Qualifications"
			}
		));
		table_4.getColumnModel().getColumn(1).setPreferredWidth(110);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(110);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(105);
		table_4.getColumnModel().getColumn(4).setPreferredWidth(107);
		
		JLabel lblNewLabel_5 = new JLabel("Interviews");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 10, 214, 37);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New Interview");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(825, 27, 443, 45);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Company ID");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_7.setBounds(856, 117, 169, 29);
		panel_3.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1077, 117, 169, 29);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Post");
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_7_1.setBounds(856, 156, 169, 29);
		panel_3.add(lblNewLabel_7_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1077, 156, 169, 29);
		panel_3.add(textField_5);
		
		JLabel lblNewLabel_7_2 = new JLabel("Salary");
		lblNewLabel_7_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_7_2.setBounds(856, 195, 169, 29);
		panel_3.add(lblNewLabel_7_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1077, 195, 169, 29);
		panel_3.add(textField_6);
		
		JLabel lblNewLabel_7_3 = new JLabel("Qualifications");
		lblNewLabel_7_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_7_3.setBounds(856, 234, 169, 29);
		panel_3.add(lblNewLabel_7_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1077, 234, 169, 29);
		panel_3.add(textField_7);
		
		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(i_id) from interviews";
					
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into interviews values(?,?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newuid);
					ps.setString(2, textField_4.getText());
					ps.setString(3, textField_5.getText());
					ps.setString(4, textField_6.getText());
//					ps.setLong(4,Long.parseLong(phone.getText()));
					ps.setString(5,textField_7.getText());
//					ps.setString(6, pass);
					//System.out.print(pass);
					try {
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Interview added succesfully");
							Faculty_home fh = new Faculty_home(rs.getInt("f_id"));
							fh.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}catch(Exception e1) {
						System.out.println(e);
					}
				}catch(Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_5.setBounds(996, 319, 112, 29);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Refresh");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement st2 = con.createStatement();
					
					ResultSet rs2 = st2.executeQuery("select i.i_id,c.c_name,i.i_post,i.i_salary,i.i_qualification from interviews i,company c where c.c_id=i.c_id order by i.i_id");
					table_4.setModel(DbUtils.resultSetToTableModel(rs2));
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_5_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_5_1.setBounds(566, 23, 112, 29);
		panel_3.add(btnNewButton_5_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Placements", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 65, 648, 423);
		panel_1.add(scrollPane_2);
		
		table_3 = new JTable();
		scrollPane_2.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student ID", "Name of Student", "Company", "Post"
			}
		));
		table_3.getColumnModel().getColumn(1).setPreferredWidth(89);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(129);
		
		JLabel lblNewLabel_3 = new JLabel("Placements");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_3.setBounds(10, 10, 194, 45);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Student ID");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_4.setBounds(740, 139, 194, 31);
		panel_1.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(984, 139, 216, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Company ID");
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(740, 180, 194, 31);
		panel_1.add(lblNewLabel_4_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(984, 180, 216, 31);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Post");
		lblNewLabel_4_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_4_1_1.setBounds(740, 221, 194, 31);
		panel_1.add(lblNewLabel_4_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(984, 221, 216, 31);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_4_2 = new JLabel("Add new placement");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel_4_2.setBounds(838, 53, 253, 45);
		panel_1.add(lblNewLabel_4_2);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt = conn.createStatement();
					String query = "select count(p_id) from placements";
					
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					int uid = rs.getInt(1);
					int newuid = uid+1;
					
					String sql = "insert into placements values(?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,newuid);
					ps.setString(2, textField_1.getText());
					ps.setString(3, textField_2.getText());
//					ps.setLong(4,Long.parseLong(phone.getText()));
					ps.setString(4,textField_3.getText());
//					ps.setString(6, pass);
					//System.out.print(pass);
					try {
						int i = ps.executeUpdate();
						System.out.println(i);
						if(i!=0) {
							JOptionPane.showMessageDialog(null, "Placement added succesfully");
							Faculty_home fh = new Faculty_home(rs.getInt("f_id"));
							fh.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}catch(Exception e1) {
						System.out.println(e);
					}
				}catch(Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_4.setBounds(922, 295, 100, 31);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Refresh");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//select p.p_id,s.s_id,s.s_name,c.c_name,p.post from students s,company c,placements p where s.s_id=p.s_id and p.c_id=c.c_id;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement st2 = con.createStatement();
					
					ResultSet rs2 = st2.executeQuery("select p.p_id,s.s_id,s.s_name,c.c_name,p.post from students s,company c,placements p where s.s_id=p.s_id and p.c_id=c.c_id order by p.p_id");
					table_3.setModel(DbUtils.resultSetToTableModel(rs2));
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_4_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_4_1.setBounds(558, 24, 100, 31);
		panel_1.add(btnNewButton_4_1);
	}
}
