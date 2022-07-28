
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import studentDashboardPanels.ClassPanel;
import studentDashboardPanels.StudentsPanel;
import studentDashboardPanels.PersonalInfo;
import studentDashboardPanels.SettingsPanel;
import studentDashboardPanels.TeacherPanel;

import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StudentDashboard extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard frame = new StudentDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	JButton btnNewButton;
	public StudentDashboard() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("studentLogo.png")).getImage());
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Student Dashboard");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menupanel = new JPanel();
		menupanel.setBorder(null);
		menupanel.setBackground(SystemColor.menu);
		menupanel.setBounds(0, 52, 200, 700);
		contentPane.add(menupanel);
		menupanel.setLayout(null);
		
		JPanel menu1 = new JPanel();
		menu1.setBorder(null);
		menu1.setBackground(SystemColor.controlHighlight);
		menu1.setBounds(0, 0, 200, 45);
		menupanel.add(menu1);
		menu1.setLayout(new BorderLayout(0, 0));
		menu1.addMouseListener(new PaneButtonMouseAdapter(menu1) {
			
			@Override
			public void mousePressed (MouseEvent e) {
				menuClicked(personalInfo);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Pesonal Information");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		menu1.add(lblNewLabel_1);
		
		JPanel menu2 = new JPanel();
		menu2.setBorder(null);
		menu2.setBackground(SystemColor.controlHighlight);
		menu2.setBounds(0, 45, 200, 45);
		menupanel.add(menu2);
		menu2.setLayout(new BorderLayout(0, 0));
		menu2.addMouseListener(new PaneButtonMouseAdapter(menu2) {
			@Override
			public void mousePressed (MouseEvent e) {
				menuClicked(classPanel);
			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel("Class");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		menu2.add(lblNewLabel_1_1);
		
		JPanel menu3 = new JPanel();
		menu3.setBorder(null);
		menu3.setBackground(SystemColor.controlHighlight);
		menu3.setBounds(0, 90, 200, 45);
		menupanel.add(menu3);
		menu3.setLayout(new BorderLayout(0, 0));
		menu3.addMouseListener(new PaneButtonMouseAdapter(menu3) {
			@Override
			public void mousePressed (MouseEvent e) {
				menuClicked(coursePanel);
			}
		});
		
		JLabel lblNewLabel_1_2 = new JLabel("Student");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		menu3.add(lblNewLabel_1_2);
		
		JPanel menu4 = new JPanel();
		menu4.setBorder(null);
		menu4.setBackground(SystemColor.controlHighlight);
		menu4.setBounds(0, 135, 200, 45);
		menupanel.add(menu4);
		menu4.setLayout(new BorderLayout(0, 0));
		menu4.addMouseListener(new PaneButtonMouseAdapter(menu4) {
			@Override
			public void mousePressed (MouseEvent e) {
				menuClicked(teacherPanel);
			}
		});
		
		JLabel lblNewLabel_1_3 = new JLabel("Teacher");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		menu4.add(lblNewLabel_1_3);
		
		JPanel menu5 = new JPanel();
		menu5.setBorder(null);
		menu5.setBackground(SystemColor.controlHighlight);
		menu5.setBounds(0, 180, 200, 45);
		menupanel.add(menu5);
		menu5.setLayout(new BorderLayout(0, 0));
		menu5	.addMouseListener(new PaneButtonMouseAdapter(menu5) {
			@Override
			public void mousePressed (MouseEvent e) {
				menuClicked(settingsPanel);
			}
		});
		
		JLabel lblNewLabel_1_4 = new JLabel("Settings");
		lblNewLabel_1_4.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 14));
		menu5.add(lblNewLabel_1_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1184, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SMS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(70, 11, 68, 30);
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);
		
		btnNewButton = new JButton("<");
		btnNewButton.setBounds(0, 5, 43, 40);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(this);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new PaneButtonMouseAdapter1(btnNewButton));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(SystemColor.info);
		infoPanel.setBounds(199, 52, 985, 609);
		contentPane.add(infoPanel);
		
		personalInfo = new PersonalInfo();
		personalInfo.setBounds(0, 0, 985, 609);
		classPanel = new ClassPanel();
		classPanel.setBounds(0, 0, 985, 609);
		coursePanel = new StudentsPanel();
		coursePanel.setBounds(0, 0, 985, 609);
		teacherPanel = new TeacherPanel();
		teacherPanel.setBounds(0, 0, 985, 609);
		settingsPanel = new SettingsPanel();
		settingsPanel.setBounds(0, 0, 985, 609);
		infoPanel.setLayout(null);
		
		infoPanel.add(personalInfo);
		infoPanel.add(classPanel);
		infoPanel.add(coursePanel);
		infoPanel.add(teacherPanel);
		infoPanel.add(settingsPanel);
		
		menuClicked(personalInfo);
	}
	
	private PersonalInfo personalInfo;
	private ClassPanel classPanel;
	private StudentsPanel coursePanel;
	private TeacherPanel teacherPanel;
	private SettingsPanel settingsPanel;
	
	public void menuClicked(JPanel panel) {
		personalInfo.setVisible(false);
		classPanel.setVisible(false);
		coursePanel.setVisible(false);
		teacherPanel.setVisible(false);
		settingsPanel.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PaneButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PaneButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.white);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(SystemColor.controlHighlight);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.white);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(SystemColor.controlHighlight);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(Color.white);
		}
	}
	private class PaneButtonMouseAdapter1 extends MouseAdapter{
		JButton button;
		public PaneButtonMouseAdapter1(JButton button) {
			this.button = button;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			button.setBackground(Color.LIGHT_GRAY);
	}
		@Override
		public void mouseExited(MouseEvent e) {
			button.setBackground(Color.black);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton) {
			StudentLogIn login = new StudentLogIn();
			this.dispose();
		}
	}
}
