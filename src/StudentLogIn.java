
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import functions.PersonalDataSetter;

public class StudentLogIn extends JFrame implements ActionListener{

	ImageIcon image = new ImageIcon("/StudentManagement/src/SPACERENT logo.png");
	JLabel title;
	JPanel username, password,top,mid,low, motherPanel,idPanel;
	JButton logIn, createAccount, exit;
	JTextField usernameField,idField;
	JPasswordField passwordField;
	
	static final String DRIVER = "com.mysql.jdbc.Driver" ;
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String USERNAME = "root";
	static final String PASSWORD = "fmbags";
	
	
	 public StudentLogIn(){
		
		title = new JLabel("STUDENT PORTAL");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(Color.black);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setIcon(image);
		
		usernameField = new JTextField();
		usernameField.setBounds(231,90, 150, 30);
		usernameField.setBorder(null);
		usernameField.setBackground(new Color(211,211,211));
		usernameField.setMargin(new Insets(50,50,50,50));
		usernameField.addKeyListener(new CustomKeyListener());
		
		
		
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
		passwordField.addKeyListener(new CustomKeyListener());

		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.white);
		password = new JPanel();
		password.setBounds(380, 140, 100, 30);
		password.setBackground(Color.black);
		password.add(passwordLabel);
		
		logIn = new JButton("Log In");
		logIn.setBounds(310, 190, 80, 30);
		logIn.setFocusable(false);
		logIn.setBorder(null);
		logIn.setBackground(Color.green);
		logIn.setForeground(Color.white);
		logIn.addActionListener(this);
		
		createAccount = new JButton("Create Account");
		createAccount.setBounds(0, 100, 110, 30);
		createAccount.setFocusable(false);
		createAccount.setBorder(null);
		createAccount.setBackground(Color.green);
		createAccount.setForeground(Color.white);
		createAccount.addActionListener(this);
		
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
		mid.add(logIn);
		
		low = new JPanel();
		low.setBounds(0, 300, 700, 200);
		low.setLayout(null);
		low.setOpaque(false);
		low.add(createAccount);
		low.add(exit);
		
		
		
		this.add(top);
		this.add(mid);
		this.add(low);	
		this.addKeyListener(new CustomKeyListener());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Student Portal");
		this.setSize(700, 500);
		this.setIconImage(new ImageIcon(getClass().getResource("studentLogo.png")).getImage());
		this.getContentPane().setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logIn) {
			InsertData insert = new InsertData();
			
		}
		if(e.getSource()==createAccount) {
			System.out.println("Create Account");
		}
		if(e.getSource()==exit) {
			this.dispose();
			HomeFrame home = new HomeFrame();
		}
		if(e.getSource()==createAccount) {
			this.dispose();
			StudentRegistration registration = new StudentRegistration();
		}
	}

	class CustomKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()== KeyEvent.VK_ENTER) {
				InsertData insert = new InsertData();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class InsertData {
		
		public InsertData() {
			try {
				//get connection to data base
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				
				//Create a statement
				Statement stmt = con.createStatement();
				
				//sql query
				String sql = "select * from student_login where username='"+usernameField.getText()+"' and password='"+passwordField.getText().toString()+"'";
				
				//process the result
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Log in Successful");
					System.out.println("username: "+ rs.getString("username")+ "\npassword: "+ rs.getString("password"));
					PersonalDataSetter set = new PersonalDataSetter(rs.getInt(1));
					StudentDashboard dashboard = new StudentDashboard();
					dashboard.main(null);
					StudentLogIn.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to Log in");
					System.out.println("there might be a problem with the input username and password");
				
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
