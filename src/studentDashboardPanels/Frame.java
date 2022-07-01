package studentDashboardPanels;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener {
	GameFrame snake;
	
	Frame(){
		
		JButton SnakeButton = new JButton("Snake Game");
		SnakeButton.addActionListener(e -> new GameFrame() );
		
		
		this.add(SnakeButton);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(rootPaneCheckingEnabled);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
