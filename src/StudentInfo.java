import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class StudentInfo extends JFrame implements ActionListener{

	

static final String DRIVER = "com.mysql.jdbc.Driver" ;
static final String URL = "jdbc:mysql://localhost:3306/demo";
static final String USERNAME = "root";
static final String PASSWORD = "fmbags";
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField classField;
	private JTextField courseField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField genderField;

	/**
	 * Create the panel.
	 */
	
	JButton btnNewButton;
	private JPanel email;
	private JPanel phone;
	private JPanel gender;
	private JLabel lblNewLabel;
	private JLabel lblClass;
	private JLabel lblCourse;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblGender;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		
		
		nameField = new JTextField();
		nameField.setBounds(328, 86, 160, 42);
		add(nameField);
		nameField.setColumns(10);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(328, 139, 160, 42);
		add(classField);
		
		courseField = new JTextField();
		courseField.setColumns(10);
		courseField.setBounds(328, 192, 160, 42);
		add(courseField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(328, 245, 160, 42);
		add(emailField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(328, 298, 160, 42);
		add(phoneField);
		
		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(328, 351, 160, 42);
		genderField.addKeyListener(new CustomKeyListener());
		add(genderField);
		
		btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(300, 420, 100, 30);
		btnNewButton.addActionListener(this);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.green);
		btnNewButton.setForeground(Color.white);
		add(btnNewButton);
		
		JPanel name = new JPanel();
		name.setBackground(Color.BLACK);
		name.setBounds(196, 86, 122, 42);
		add(name);
		name.setLayout(null);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(36, 11, 53, 26);
		lblNewLabel.setForeground(Color.WHITE);
		name.add(lblNewLabel);
		
		JPanel Class = new JPanel();
		Class.setBackground(Color.BLACK);
		Class.setBounds(196, 139, 122, 42);
		add(Class);
		Class.setLayout(null);
		
		lblClass = new JLabel("Class");
		lblClass.setForeground(Color.WHITE);
		lblClass.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClass.setBounds(34, 11, 53, 26);
		Class.add(lblClass);
		
		JPanel course = new JPanel();
		course.setBackground(Color.BLACK);
		course.setBounds(196, 192, 122, 42);
		add(course);
		course.setLayout(null);
		
		lblCourse = new JLabel("Course");
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCourse.setBounds(34, 11, 53, 26);
		course.add(lblCourse);
		
		email = new JPanel();
		email.setBackground(Color.BLACK);
		email.setBounds(196, 245, 122, 42);
		add(email);
		email.setLayout(null);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(35, 11, 53, 26);
		email.add(lblEmail);
		
		phone = new JPanel();
		phone.setBackground(Color.BLACK);
		phone.setBounds(196, 298, 122, 42);
		add(phone);
		phone.setLayout(null);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhone.setBounds(36, 11, 53, 26);
		phone.add(lblPhone);
		
		gender = new JPanel();
		gender.setBackground(Color.BLACK);
		gender.setBounds(196, 351, 122, 42);
		add(gender);
		gender.setLayout(null);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGender.setBounds(36, 11, 53, 26);
		gender.add(lblGender);
		
		lblNewLabel_1 = new JLabel("Registration Form");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(260, 27, 180, 25);
		add(lblNewLabel_1);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Registration Form");
		this.setSize(700, 500);
		this.setIconImage(new ImageIcon(getClass().getResource("studentLogo.png")).getImage());
		this.getContentPane().setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==btnNewButton) {
			InsertData insert = new InsertData();
		}
	}
	
	class InsertData{
		
		public InsertData() {
try {
				
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				PreparedStatement ps = con.prepareStatement("insert into student_info values(?,?,?,?,?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2,nameField.getText());  
				ps.setString(3, classField.getText());  
				ps.setString(4, courseField.getText()); 
				ps.setString(5, emailField.getText()); 
				ps.setString(6, phoneField.getText()); 
				ps.setString(7, genderField.getText()); 
				
				int i=ps.executeUpdate();  
				System.out.println(i+" records affected");
				
				
				con.close();  
				JOptionPane.showMessageDialog(null, "Account Registered");
				StudentRegistration register = new StudentRegistration();
				register.dispose();
				StudentInfo.this.dispose();
				StudentLogIn log = new StudentLogIn();
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
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
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				InsertData insert = new InsertData();
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
