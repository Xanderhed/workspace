import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class cell extends JPanel {
	
	private JLabel threatLabel, dangerLabel;
	private statusPanel status;
	private int threat;
	private boolean isMine, isActive, isDangerous;
	
	//constructor
	public cell(statusPanel stats) {
		
		super(new BorderLayout());
		this.setBackground(Color.GRAY);
		threatLabel = new JLabel("Error");
		dangerLabel = new JLabel("DANGER");
		this.threatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.threatLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.dangerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.dangerLabel.setVerticalAlignment(SwingConstants.CENTER);
		isMine = false;
		isActive = true;
		isDangerous = false;
		status = stats;
	}
	
	//method
	public void clear() {
	
		if(isDangerous) {
			status.incrementLabel();
		}
		this.removeAll();
	}
	
	public boolean isMine() {
		
		return isMine;
	}
	
	public void armMine() {
		
		isMine = true;
	}
	
	public void setThreatLabel() {
		
		if(isMine) threatLabel.setText("BOOM!");
		else if(threat > 0) threatLabel.setText(String.valueOf(threat));
		else threatLabel.setText("");
	}
	
	public void showThreatLabel() {
		
		this.setBackground(Color.WHITE);
		this.add(threatLabel);
		this.revalidate();
		this.repaint();
	}
	
	public void flipDanger() {

		if(isDangerous) {
			
			this.removeAll();
			this.revalidate();
			this.repaint();
			status.incrementLabel();
			isDangerous = false;
		}
		else {
			
			this.add(dangerLabel);
			this.revalidate();
			this.repaint();
			status.decrementLabel();
			isDangerous = true;
		}
	}
	
	public void incrementThreat() {
		//increments the threat level of the panel, culminating in the number of mines adjacent to the panel
		threat++;
	}
	
	public int threat() {
		
		return threat;
	}
	
	public boolean isActive() {
		
		return isActive;
	}
	
	public void deactivate() {
		
		isActive = false;
	}
	
	public void press() {
		
		clear();
		setThreatLabel();
		showThreatLabel();
		deactivate();
	}
}
