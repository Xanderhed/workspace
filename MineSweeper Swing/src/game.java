import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Color;
import java.util.Random;
import java.lang.Math;

@SuppressWarnings("serial")
public class game extends JPanel {
	
	private cell[][] cells;
	private statusPanel status;
	private int ROWS, COLUMNS, numBombs;
	
	//constructor
	public game(int rows, int cols, int bombs, statusPanel stats) {
		
		super(new GridLayout(rows, cols, 1, 1));
		this.setBackground(Color.BLACK);
		ROWS = rows;
		COLUMNS = cols;
		numBombs = bombs;
		cells = new cell[ROWS][COLUMNS];
		status = stats;
		fillGrid();
		plantBombs();
		checkThreat();
	}
	
	//methods
	public cell[][] getGrid() {
		
		return cells;
	}
	
	public cell getCell(int i, int j) {
		
		return cells[i][j];
	}
	
	private void fillGrid() {
		
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLUMNS; j++) {
				cells[i][j] = new cell(status);
				this.add(cells[i][j]);
			}
		}
	}
	
	private void plantBombs(){
		//This method randomly arms a number of mines on the minefield
		Random base = new Random();
		int bombColumn, bombRow; 
		for (int i = 0; i < numBombs;){
			bombRow = Math.abs(base.nextInt() % this.ROWS);
			bombColumn = Math.abs(base.nextInt() % this.COLUMNS);
			if (cells[bombRow][bombColumn].isMine()) continue;
			else {
				cells[bombRow][bombColumn].armMine();
				i++;
				continue;
			}
		}
	}
	
	private void checkThreat(){
		//checks how many mines are adjacent to the desired cell
		//selecting a cell
		for(int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMNS; j++){
				//checking all cells around selected cell
				for(int m = i-1; m <= i+1; m++){
					for(int n = j-1; n <= j+1; n++){
						try{
							if (cells[m][n].isMine()) cells[i][j].incrementThreat();
						}catch(ArrayIndexOutOfBoundsException e){
							//sometimes this method will call indicies that are out of bounds. If this happens, skip the iteration and continue
							continue;
						}
					}
				}
			}
		}
	}
}
