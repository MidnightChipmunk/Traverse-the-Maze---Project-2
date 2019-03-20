import javax.swing.JOptionPane;

public class MazeBuilder {
	public static Cell[][] loadMazeRandom(){
		Cell[][] grid;
		int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows"));
		int columns = Integer.parseInt(JOptionPane.showInputDialog("Enter number of columns"));
		double prob = Double.parseDouble(JOptionPane.showInputDialog("Enter passage probability"));
		
		grid = new Cell[rows][columns];
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = new Cell(i, j);
			}
		}
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				Cell[] neigh = grid[i][j].getNeighbors();
				for(int k = 0; k < neigh.length; k++){
					switch(k){
					case 0:
						if(j > 0){
							neigh[k] = (Math.random()<prob) ? grid[i][j-1] : null;
						}else{
							neigh[k] = null;
						}
						break;
					case 1:
						if(i < rows-1){
							neigh[k] = (Math.random()<prob) ? grid[i+1][j] : null;
						}else{
							neigh[k] = null;
						}
						break;
					case 2:
						if(j < columns-1){
							neigh[k] = (Math.random()<prob) ? grid[i][j+1] : null;
						}else{
							neigh[k] = null;
						}
						break;
					case 3:
						if(i > 0){
							neigh[k] = (Math.random()<prob) ? grid[i-1][j] : null;
						}else{
							neigh[k] = null;
						}
						break;
					}
				}
			}
		}
		
		return grid;
	}
}
