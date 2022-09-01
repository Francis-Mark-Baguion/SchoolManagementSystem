package adminDashboardPanels;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminClassPanel extends JPanel {

	static final String DRIVER = "com.mysql.jdbc.Driver" ;
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String USERNAME = "root";
	static final String PASSWORD = "fmbags";
	String where = "class1";
	
	Object[] row;
	JTable table = new JTable();
	JScrollPane scrollPane;
	DefaultTableModel model= new DefaultTableModel();
	
	
	public AdminClassPanel() {
		row = new Object[7];
		setLayout(null);
		setBounds(0, 0, 985, 609);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 985, 609);
		add(scrollPane);
		
		table.setModel(model);
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.black);
		table.setSelectionForeground(Color.white);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		add(scrollPane);
		display();
	}
	
	private void display() {
		model.setRowCount(0);
		
		try {
			Class.forName(DRIVER);
			
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			String query = "select * from student_info";
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rmsd  = rs.getMetaData();
			
			int cols= rmsd.getColumnCount();
			String[] colName=new String[cols];
			for (int i=0;i<cols;i++)
			    colName[i]=rmsd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			
			while(rs.next()) {
				
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				
				model.addRow(row);
			}
			
			
		}
		catch(Exception e){
			System.out.println("some ting went wong");
		}
	}
	public JTable getTable() {
		return table;
	}

	public void setTable(Color color1, Color color2) {
		this.table.setBackground(color1);
		this.table.setForeground(color2);
		this.table.setGridColor(color2);
		this.table.setSelectionForeground(color1);
		this.scrollPane.setBackground(color1);
	}

}

