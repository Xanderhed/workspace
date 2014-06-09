import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class statusPanel extends JPanel{

	private JLabel label;
	private JButton button;
	private int mines;
	
	//constructor
	public statusPanel(int maxMines) {
		
		super(new BorderLayout());
		label = new JLabel();
		button = new JButton("New Game");
		mines = maxMines;
		this.add(label, BorderLayout.SOUTH);
		this.add(button, BorderLayout.NORTH);
		this.label.setHorizontalAlignment(SwingConstants.CENTER);
		this.label.setVerticalAlignment(SwingConstants.CENTER);
		this.updateLabel("Mines remaining: " + mines);
	}
	
	//methods
	public void updateLabel(String text) {
		
		label.setText(text);
	}
	
	public void incrementLabel() {
		
		mines++;
		updateLabel("Mines remaining: " + mines);
	}
	
	public void decrementLabel() {
		
		mines--;
		updateLabel("Mines remaining: " + mines);
	}
	
	public void gameOver(boolean victory) {
		
		if(victory) updateLabel("Congratulations! The you have cleared the minefield!");
		else updateLabel("Detonation! Better luck next time.");
	}
	
	public void addActionListener(ActionListener listener) {
		
		button.addActionListener(listener);
	}
	
}
