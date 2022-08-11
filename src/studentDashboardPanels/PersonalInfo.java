package studentDashboardPanels;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import functions.dataRetrieve;

import javax.swing.JLabel;

public class PersonalInfo extends JPanel {
	
	String name;

	dataRetrieve data;
	credentials userinfo = new credentials();
	
	public PersonalInfo() {
		
		data = new dataRetrieve(userinfo.getid());
		
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
		
		JLabel nameLabel = new JLabel();
		nameLabel.setBounds(10, 0, 142, 31);
		namePanel.add(nameLabel);
		
		JPanel classPanel = new JPanel();
		classPanel.setLayout(null);
		classPanel.setBounds(29, 221, 162, 31);
		add(classPanel);
		
		JLabel classLabel = new JLabel(data.getClasses());
		classLabel.setBounds(10, 0, 142, 31);
		classPanel.add(classLabel);
		
		JLabel nameLabel_2 = new JLabel();
		nameLabel_2.setBounds(10, 0, 142, 31);
		classPanel.add(nameLabel_2);
		
		JPanel coursePabel = new JPanel();
		coursePabel.setLayout(null);
		coursePabel.setBounds(29, 263, 162, 31);
		add(coursePabel);
		
		JLabel courseLabel = new JLabel(data.getCourse());
		courseLabel.setBounds(10, 0, 142, 31);
		coursePabel.add(courseLabel);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(null);
		emailPanel.setBounds(29, 305, 162, 31);
		add(emailPanel);
		
		JLabel emailLabel = new JLabel("");
		emailLabel.setBounds(10, 0, 142, 31);
		emailPanel.add(emailLabel);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(null);
		phonePanel.setBounds(29, 345, 162, 31);
		add(phonePanel);
		
		JLabel phoneLabel = new JLabel("");
		phoneLabel.setBounds(10, 0, 142, 31);
		phonePanel.add(phoneLabel);
		
		JPanel genderPanel = new JPanel();
		genderPanel.setLayout(null);
		genderPanel.setBounds(29, 387, 162, 31);
		add(genderPanel);
		
		JLabel genderLabel = new JLabel(data.getGender());
		genderLabel.setBounds(10, 0, 142, 31);
		genderPanel.add(genderLabel);
		
	}
	
	
}
