package studentDashboardPanels;
import javax.swing.JPanel;
import java.awt.Color;

public class PersonalInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	GamePanel game;
	public PersonalInfo() {
		
		game = new GamePanel();
		
		setBackground(Color.BLUE);
		setBounds(0, 0, 985, 609);
		this.add(game);
	}

}
