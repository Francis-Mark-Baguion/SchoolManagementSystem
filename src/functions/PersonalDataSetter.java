package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PersonalDataSetter {
	int id;
	
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String PASSWORD = "fmbags";
	static final String USERNAME = "root";
	
	public PersonalDataSetter() {
		
	}
	
	public PersonalDataSetter(int id) {
		try {
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			PreparedStatement ps = con.prepareStatement("insert into idtable values(?)");
			ps.setInt(1, id); 
			
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");
			
			con.close();
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
}
