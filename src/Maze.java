
public class Maze {
	private Cell entrance;
	private Cell exit;
	private Cell[][] grid;
	private int rows;
	private int columns;
	private boolean pathFound;
	private LinkedStack<Cell> path;
	
	public Maze(Cell[][] grid){
		this.grid = grid;
		rows = grid.length;
		columns = grid[0].length;
		entrance = grid[0][0];
		exit = grid[rows-1][columns-1];
		pathFound = false;
		path = new LinkedStack<Cell>();
	}
	
	public void findPath(Cell node){
		Cell[] neigh = node.getNeighbors();	
		path.push(node);	
		node.visited(true);
		
		if(path.peek() == exit){
			pathFound = true;
			return;
		}
		
		while(!path.isEmpty() && !pathFound){
			for(int i = 0; i < neigh.length; i++){
				if(neigh[i] != null && !neigh[i].beenVisited() && !pathFound){
						findPath(neigh[i]);
				}
			}
			
			if(!pathFound){
				path.pop();
				return;
			}
		}
		
		return;
	}
	
	public void display(){
		LinkedStack<Cell> temp = path;
		int move = 1;
		int[][] grid = new int[rows][columns];
		for(int i = temp.size(); i > 0; i--){
			grid[temp.peek().getRow()][temp.peek().getColumn()] = move;
			temp.pop();
			move++;
		}
		
		for(int i = 0; i < rows; i++){
			System.out.println("\n");
			for(int j = 0; j < columns; j++){
				if(grid[i][j] == 0){
					System.out.print(" --- ");
				}else{
					System.out.print("  " + grid[i][j] + (grid[i][j] > 9 ? " " : "  "));
				}
			}
		}
		
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
