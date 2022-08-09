package functions;
import java.sql.*;
public class dataRetrieve {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc://mysql:localhost:336/demo";
	static final String PASSWORD = "fmbags";
	static final String USERNAME = "root";
	
	int id;
	dataRetrieve(int id){
		
		try {
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "Select * from student_info where id = ";
			
		}
		catch(Exception e){
			
		}
	}
}
