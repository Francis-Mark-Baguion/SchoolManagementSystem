import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdminInfo extends JFrame implements ActionListener {

	
	static final String DRIVER = "com.mysql.jdbc.Driver" ;
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String USERNAME = "root";
	static final String PASSWORD = "fmbags";
		private JTextField nameField;
		private JTextField classField;
		/**
		 * Create the panel.
		 */
		
		JButton btnNewButton;
		private JLabel lblNewLabel;
		private JLabel lblClass;
		private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInfo frame = new AdminInfo();
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
	public AdminInfo() {
		nameField = new JTextField();
		nameField.setBounds(328, 86, 160, 42);
		add(nameField);
		nameField.setColumns(10);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(328, 139, 160, 42);
		add(classField);
		
		
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
		
		lblClass = new JLabel("Subject");
		lblClass.setForeground(Color.WHITE);
		lblClass.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClass.setBounds(34, 11, 53, 26);
		Class.add(lblClass);
		
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
			InsertData insert =new InsertData();
			StudentRegistration register = new StudentRegistration();
			register.dispose();
			this.dispose();
		}
	}
	
	class InsertData{
		
		public InsertData() {
try {
				
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				PreparedStatement ps = con.prepareStatement("insert into teacher_info values(?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2,nameField.getText());  
				ps.setString(3, classField.getText());  
				
				
				int i=ps.executeUpdate();  
				System.out.println(i+" records affected");
				
				
				con.close();  
				JOptionPane.showMessageDialog(null, "Account Registered");
				StudentRegistration register = new StudentRegistration();
				register.dispose();
				AdminInfo.this.dispose();
				AdminLogIn log = new AdminLogIn();
				
				
				
				
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
