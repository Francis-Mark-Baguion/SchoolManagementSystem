package studentDashboardPanels;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		teachersname.setBounds(57, 58, 156, 20);
		add(teachersname);
		teachersname.setColumns(10);
		
		
		
		message = new JTextArea();
		message.setBounds(62, 123, 271, 271);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		add(message);
		
		sendbutton = new JButton("Send");
		sendbutton.setBounds(137, 443, 89, 23);
		add(sendbutton);
		sendbutton.addActionListener(this);
		
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
