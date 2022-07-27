import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeFrame extends JFrame implements ActionListener{

	JLabel title;
	JButton Student,Teacher;
	JPanel top,mid,low;
	
	HomeFrame(){
		
		title = new JLabel("Student Management System");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial",Font.BOLD,30));
		
		Student = new JButton("Student");
		Student.setBounds(300, 90, 100, 30);
		Student.addActionListener(this);
		Student.setBackground(Color.green);
		Student.setFocusable(false);
		Student.setBorder(null);
		Student.setForeground(Color.white);
		
		Teacher = new JButton("Teacher");
		Teacher.setBounds(300, 160, 100, 30);
		Teacher.addActionListener(this);
		Teacher.setBackground(Color.green);
		Teacher.setFocusable(false);
		Teacher.setBorder(null);
		Teacher.setForeground(Color.white);
		
		top = new JPanel();
		top.setBounds(0, 0, 700, 50);
		top.add(title);
		top.setBackground(Color.white);
		
		mid = new JPanel();
		mid.setBounds(0, 50, 700, 300);
		mid.setBackground(Color.white);
		mid.setLayout(null);
		mid.add(Student);
		mid.add(Teacher);
		
		this.add(top);
		this.add(mid);  
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(700, 500);
		this.setTitle("Student Management System");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setIconImage(new ImageIcon(getClass().getResource("studentLogo.png")).getImage());
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Student) {
			StudentLogIn student = new StudentLogIn();
			this.dispose();
			
			
		}
		if(e.getSource()==Teacher) {
			TeacherLogIn teacher = new TeacherLogIn();
			this.dispose();
		}
	}
}
