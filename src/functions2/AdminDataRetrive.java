package functions2;
import java.sql.*;

public class AdminDataRetrive {

	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String PASSWORD = "fmbags";
	static final String USERNAME = "root";
	
	private String name, Classes, course, email, phone, gender;
	
	int id;
	public AdminDataRetrive(int id){
		
		try {
			
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String sql = "Select * from teacher_info where id = '"+id+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				name = rs.getString("name");
				Classes = rs.getString("subject");
			}
			
		}
		catch(Exception e){
			System.out.println("there seems to be an error");
			System.out.println(e.getMessage());
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return Classes;
	}
	public void setClass(String class1) {
		Classes = class1;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
