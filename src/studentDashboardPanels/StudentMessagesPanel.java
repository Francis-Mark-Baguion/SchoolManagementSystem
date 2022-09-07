package studentDashboardPanels;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class StudentMessagesPanel extends JPanel implements ActionListener {
	private JTextField teachersname;
	private JTextArea message;
	private JButton sendbutton;
	
	static final String DRIVER = "com.mysql.jdbc.Driver" ;
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String USERNAME = "root";
	static final String PASSWORD = "fmbags";
	/**
	 * Create the panel.
	 */
	public StudentMessagesPanel() {
		setBounds(0, 0, 985, 609);
		setLayout(null);
		
		teachersname = new JTextField();
		teachersname.setBounds(89, 38, 156, 20);
		add(teachersname);
		teachersname.setColumns(10);
		
		
		
		message = new JTextArea();
		message.setBounds(62, 123, 353, 423);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		message.setBorder(BorderFactory.createLineBorder(Color.black));
		add(message);
		
		sendbutton = new JButton("Send");
		sendbutton.setBounds(326, 575, 89, 23);
		add(sendbutton);
		sendbutton.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setBounds(62, 41, 46, 14);
		add(lblNewLabel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sendbutton) {
			InsertData();
		}
	}
	
	public void InsertData() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement ps = con.prepareStatement("INSERT INTO messages values(?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, teachersname.getText());
			ps.setString(3, message.getText());
			
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");
			JOptionPane.showMessageDialog(null, "message sent");
			
			
			con.close();
			teachersname.setText("");
			message.setText("");
			
		} catch(Exception e){
			
		}
	}
}
