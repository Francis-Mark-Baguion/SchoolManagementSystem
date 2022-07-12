
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StudentAccount extends JFrame implements ActionListener {
	ImageIcon image = new ImageIcon("/StudentManagement/src/SPACERENT logo.png");
	JLabel title;
	JPanel username, password,top,mid,low, motherPanel,Classes;
	JButton signIn, createAccount, exit;
	JTextField usernameField,classField;
	JPasswordField passwordField;
	
	public StudentAccount(){
		title = new JLabel("Registration Form");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(Color.black);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setIcon(image);
		
		usernameField = new JTextField();
		usernameField.setBounds(231,90, 150, 30);
		usernameField.setBorder(null);
		usernameField.setBackground(new Color(211,211,211));
		usernameField.setMargin(new Insets(50,50,50,50));
		
		
		
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(Color.white);
		username = new JPanel();
		username.setBounds(380, 90, 100, 30);
		username.setBackground(Color.black);
		username.add(usernameLabel);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(231,140, 150, 30);
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(211,211,211));
		
		classField = new JTextField();
		classField.setBounds(231,190, 150, 30);
		classField.setBorder(null);
		classField.setBackground(new Color(211,211,211));
		
		JLabel ClassesLabel = new JLabel("Classes");
		ClassesLabel.setForeground(Color.white);
		Classes = new JPanel();
		Classes.setBounds(380, 190, 100, 30);
		Classes.setBackground(Color.black);
		Classes.add(ClassesLabel);
		
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.white);
		password = new JPanel();
		password.setBounds(380, 140, 100, 30);
		password.setBackground(Color.black);
		password.add(passwordLabel);
		
		signIn = new JButton(" Sign In");
		signIn.setBounds(310, 10, 80, 30);
		signIn.setFocusable(false);
		signIn.setBorder(null);
		signIn.setBackground(Color.green);
		signIn.setForeground(Color.white);
		signIn.addActionListener(this);
		
		
		exit = new JButton("Exit");
		exit.setBounds(575, 100, 110, 30);
		exit.setFocusable(false);
		exit.setBorder(null);
		exit.setBackground(Color.red);
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		
		
		top = new JPanel();
		top.setBounds(0, 0, 700, 50);
		top.setLayout(new BorderLayout());
		top.setOpaque(false);
		top.add(title);

		
		mid = new JPanel();
		mid.setBounds(0, 50, 700, 250);
		mid.setLayout(null);
		mid.setOpaque(false);
		mid.add(username);
		mid.add(password);
		mid.add(usernameField);
		mid.add(passwordField);
		mid.add(classField);
		mid.add(Classes);
		
		low = new JPanel();
		low.setBounds(0, 300, 700, 200);
		low.setLayout(null);
		low.setOpaque(false);
		low.add(exit);
		low.add(signIn);
		
		
		
		this.add(top);
		this.add(mid);
		this.add(low);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Registration Form");
		this.setSize(700, 500);
		this.setIconImage(new ImageIcon(getClass().getResource("studentLogo.png")).getImage());
		this.getContentPane().setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	static final String DRIVER = "com.mysql.jdbc.Driver" ;
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String USERNAME = "root";
	static final String PASSWORD = "fmbags";
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			this.dispose();
		}
		if(e.getSource()==signIn) {
			try {
				Class.forName(DRIVER);
			
			Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con1.createStatement();
			String sql = "select * from student_login where username='"+usernameField.getText()+"' and password='"+passwordField.getText().toString()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Account Already Exist");
			}
			else {
				try {
					
					Class.forName(DRIVER);
					Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					
					PreparedStatement ps = con.prepareStatement("insert into student_login values(?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2,usernameField.getText());  
					  
					ps.setString(3, passwordField.getText());  
					ps.setString(4,classField.getText());
					int i=ps.executeUpdate();  
					System.out.println(i+" records affected");
					
					
					con.close();  
					JOptionPane.showMessageDialog(null, "Account Created");
					this.dispose();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			
			}
		}
	}

