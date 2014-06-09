import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Container;

@SuppressWarnings("serial")
public class MineSweeper extends JFrame {

	private final int ROWS = 16;
	private final int COLUMNS = 16;
	private final int numMines = 40;
	private final Container container;
	private game board;
	private statusPanel status;
	
	public MineSweeper() {
		
		super("Mine Sweeper");
		container = this.getContentPane();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(ROWS * 55, COLUMNS * 55 + 50);
		this.setResizable(false);
		newGame();
	}
	
	public void newGame() {
		
		container.add(status = new statusPanel(numMines), BorderLayout.NORTH);
		container.add(board = new game(ROWS, COLUMNS, numMines, status), BorderLayout.CENTER);
		container.revalidate();
		listenUp();
	}
	
	private void listenUp() {
		
		status.addActionListener(new gameListener(this));
		for(int i = 0; i < ROWS; i++) {
			
			for(int j = 0; j < COLUMNS; j++) {
				
				board.getCell(i, j).addMouseListener(new cellListener(board.getGrid(), ROWS, COLUMNS, i, j, numMines, status));
			}
		}
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				JFrame mineSweeper = new MineSweeper();
				mineSweeper.setVisible(true);
			}
		});
	}
}
