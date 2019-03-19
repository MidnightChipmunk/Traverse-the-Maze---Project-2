
public class Cell {
	private boolean visited;
	private int row;
	private int column;
	private Cell[] neighbors;
	private int lastOut;
	
	public Cell(int row, int column){
		this.row = row;
		this.column = column;
		neighbors = new Cell[4];
	}
	
	public String toString(){
		return "(" + row + "," + column + ")";
	}
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public boolean beenVisited(){
		return visited;
	}
	
	public Cell[] getNeighbors(){
		return neighbors;
	}
	
	public int lastChecked(){
		return lastOut;
	}
	
	public Cell getNeighbor(int neighbor){
		return neighbors[neighbor];
	}
	
	public void setRow(int row){
		this.row = row;
	}
	
	public void setColumn(int column){
		this.column = column;
	}
	
	public void visit(){
		visited = true;
	}
	
	public void addNeighbor(Cell neighbor, int direction){
		neighbors[direction] = neighbor;
	}
	
	public void setLastOut(int last){
		lastOut = last;
	}
}
