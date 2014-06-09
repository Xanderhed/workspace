import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;

public class gameListener implements ActionListener{

	private Container container;
	private MineSweeper mineSweeper;
	
	//constructor
	public gameListener(MineSweeper sweeper) {
		
		mineSweeper = sweeper;
		container = sweeper.getContentPane();
	}
	
	//interface methods
	public void actionPerformed(ActionEvent e) {
		
		container.removeAll();
		mineSweeper.newGame();
		//container.revalidate();
	}
}
