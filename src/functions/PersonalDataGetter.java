package functions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonalDataGetter {
	
	int id;

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String PASSWORD = "fmbags";
	static final String USERNAME = "root";
	
	
	public PersonalDataGetter() {
try {
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM idtable ORDER BY ID DESC LIMIT 1";
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				id = rs.getInt(2);
				
			}
			
		}
		catch(Exception e){
			System.out.println("there seems to be an error");
			System.out.println(e.getMessage());
		}
	}
	public int idgetter() {
		return this.id;
	}
	public void idsetter(int id) {
		this.id = id;
	}
}
