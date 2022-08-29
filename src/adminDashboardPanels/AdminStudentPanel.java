package adminDashboardPanels;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminStudentPanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	
	static final String DRIVER = "com.mysql.jdbc.Driver" ;
	static final String URL = "jdbc:mysql://localhost:3306/demo";
	static final String USERNAME = "root";
	static final String PASSWORD = "fmbags";
	
	Object[] row;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	String [] columnName = {"Id","Name"};
	
	public AdminStudentPanel() {
		row = new Object[3];
		setLayout(null);
		setBounds(0, 0, 985, 609);
		setBackground(Color.green);
		
		JScrollPane scrollPane = new JScrollPane(table);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private void display() {
		model.setRowCount(0);
		try {
						System.out.println("hello");
						Class.forName(DRIVER);
						Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
						Statement st = con.createStatement();
						String query = "select * from student_login";
						ResultSet rs = st.executeQuery(query);
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
							
							model.addRow(row);
						}
						
						
						
						
						
						
						
						
						
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("some ting went wong");
					}
				
	}
}
