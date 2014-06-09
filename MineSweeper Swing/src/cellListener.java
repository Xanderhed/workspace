import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


import javax.swing.SwingUtilities;


public class cellListener extends MouseAdapter{

	private cell[][] cells;
	private int rowIndex, columnIndex, ROWS, COLUMNS, numMines;
	private statusPanel status;
	
	//constructor
	public cellListener(cell[][] grid, int rows, int columns, int i, int j, int mines, statusPanel stats) {
		cells = grid;
		rowIndex = i;
		columnIndex = j;
		ROWS = rows;
		COLUMNS = columns;
		numMines = mines;
		status = stats;
	}
	
	//interface methods
	public void mouseClicked(MouseEvent e) {
		
		if(SwingUtilities.isRightMouseButton(e) &&  cells[rowIndex][columnIndex].isActive()) cells[rowIndex][columnIndex].flipDanger();
		else if(SwingUtilities.isLeftMouseButton(e) && cells[rowIndex][columnIndex].isActive()) {
			
			cells[rowIndex][columnIndex].press();
			//countActive();
			if(cells[rowIndex][columnIndex].threat() == 0) {
				cascade(e);
			}
			else if(cells[rowIndex][columnIndex].isMine()) {
				showMines();
				deactivateAll();
				status.gameOver(false);
			}
			else if(numMines == countActive()) {
				deactivateAll();
				status.gameOver(true);
			}
		}
	}
	
	//methods
	private void cascade(MouseEvent e) {
		
		for(int i = rowIndex-1; i <= rowIndex+1; i++) {
			for(int j = columnIndex-1; j < columnIndex+2; j++) {
				try {
					if(cells[i][j].isActive()) cells[i][j].dispatchEvent(e);
					else continue;
				} catch(ArrayIndexOutOfBoundsException exception) {
					continue;
				}
			}
		}
	}
	
	private void deactivateAll() {
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				cells[i][j].deactivate();
			}
		}
	}
	
	private void showMines() {
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				if(cells[i][j].isMine()) cells[i][j].press();
			}
		}
	}
	
	private int countActive() {
		int count = 0;
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				if(cells[i][j].isActive()) count++; 
			}
		}
		return count;
	}
}
