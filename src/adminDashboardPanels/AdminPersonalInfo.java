package adminDashboardPanels;
import javax.swing.JPanel;

import java.awt.Color;
import functions2.AdminDataRetrive;
import functions2.AdminPersonalDataGetter;

import javax.swing.JLabel;

public class AdminPersonalInfo extends JPanel {
	
	String name;
	int id;

	AdminPersonalDataGetter personal;
	AdminDataRetrive data;
	
	public AdminPersonalInfo () {
		personal = new AdminPersonalDataGetter();
		
		data = new AdminDataRetrive(personal.idgetter());
		
		setBackground(Color.WHITE);
		
		setBounds(0, 0, 985, 609);
		setLayout(null);
		
		JPanel PorfilePicPanel = new JPanel();
		PorfilePicPanel.setBackground(Color.BLACK);
		PorfilePicPanel.setForeground(Color.BLACK);
		PorfilePicPanel.setBounds(29, 11, 162, 152);
		add(PorfilePicPanel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(29, 177, 162, 31);
		add(namePanel);
		namePanel.setLayout(null);
		
		JLabel nameLabel = new JLabel(data.getName());
		nameLabel.setBounds(10, 0, 142, 31);
		namePanel.add(nameLabel);
		
		JPanel classPanel = new JPanel();
		classPanel.setLayout(null);
		classPanel.setBounds(29, 221, 162, 31);
		add(classPanel);
		
		JLabel classLabel = new JLabel(data.getClasses());
		classLabel.setBounds(10, 0, 142, 31);
		classPanel.add(classLabel);
		
		
		
	}
	
}
