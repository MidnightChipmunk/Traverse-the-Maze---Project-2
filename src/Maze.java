
public class Maze {
	private Cell entrance;
	private Cell exit;
	private Cell[][] grid;
	private int rows;
	private int columns;
	private boolean pathFound;
	private LinkedStack path;
	
	public Maze(Cell[][] grid){
		this.grid = grid;
		rows = grid[0].length;
		columns = grid.length;
		entrance = grid[0][0];
		exit = grid[rows-1][columns-1];
		pathFound = false;
		path = new LinkedStack();
	}
	
	public Cell getEntrance(){
		return entrance;
	}
	
	public Cell getExit(){
		return exit;
	}
	
	public Cell[][] getGrid(){
		return grid;
	}
	
	public Cell getCellAt(int row, int column){
		return grid[row][column];
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}
	
	public boolean getPathFound(){
		return pathFound;
	}
	
	public LinkedStack getStack(){
		return path;
	}
	
	public void setEntrance(Cell cell){
		entrance = cell;
	}
	
	public void setExit(Cell cell){
		exit = cell;
	}
	
	public void setGrid(Cell[][] grid){
		this.grid = grid;
	}
	
	public void setSetCellAt(int row, int column, Cell cell){
		grid[row][column] = cell;
	}
	
	public void setRows(int rows){
		this.rows = rows;
	}
	
	public void setColumns(int columns){
		this.columns = columns;
	}
	
	public void pathFound(){
		pathFound = true;
	}
	
	public void setStack(LinkedStack path){
		this.path = path;
	}
}
