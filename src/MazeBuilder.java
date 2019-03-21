import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
						//north
						if(i > 0){
							if(neigh[k] == null) neigh[k] = (Math.random()<prob) ? grid[i-1][j] : null;
							if(neigh[k] != null){
								neigh[k].addNeighbor(grid[i][j], k+2);
							}
						}else{
							neigh[k] = null;
						}
						break;
					case 1:
						//east
						if(j < columns-1){
							if(neigh[k] == null) neigh[k] = (Math.random()<prob) ? grid[i][j+1] : null;
							if(neigh[k] != null){
								neigh[k].addNeighbor(grid[i][j], k+2);
							}
						}else{
							neigh[k] = null;
						}
						break;
					case 2:
						//south
						if(i < rows-1){
							if(neigh[k] == null) neigh[k] = (Math.random()<prob) ? grid[i+1][j] : null;
							if(neigh[k] != null){
								neigh[k].addNeighbor(grid[i][j], k-2);
							}
						}else{
							neigh[k] = null;
						}
						break;
					case 3:
						//west
						if(j > 0){
							if(neigh[k] == null) neigh[k] = (Math.random()<prob) ? grid[i][j-1] : null;
							if(neigh[k] != null){
								neigh[k].addNeighbor(grid[i][j], k-2);
							}
							
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
	
	public static Cell[][] loadMazeFile() throws FileNotFoundException{
		Scanner eastWest = new Scanner(new File("eastWest.txt"));
		Scanner northSouth = new Scanner(new File("northSouth.txt"));
		int rows = eastWest.nextInt();
		int columns = eastWest.nextInt();
		Cell[][] grid = new Cell[rows][columns];
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				grid[i][j] = new Cell(i,j);
			}
		}
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				int ns = northSouth.nextInt();
				int ew = eastWest.nextInt();
				
				System.out.println("Cell: " + grid[i][j]);
				for(int k = 0; k < 4; k++){
					switch(k){
					case 0:
						//north
						if(ns == 0 && i > 0){
							grid[i][j].addNeighbor(grid[i-1][j], k);
							grid[i-1][j].addNeighbor(grid[i][j], k+2);
						}else{
							grid[i][j].addNeighbor(null, k);
							if(i > 0){
								grid[i-1][j].addNeighbor(null, k+2);
							}
						}
						break;
					case 1:
						//east
						if(ew == 0 && j < columns-1){
							grid[i][j].addNeighbor(grid[i][j+1], k);
							grid[i][j+1].addNeighbor(grid[i][j], k+2);
						}else{
							grid[i][j].addNeighbor(null, k);
							if(j < columns-1){
								grid[i][j+1].addNeighbor(null, k+2);
							}
						}
						break;
					case 2:
						//south
						if(ns == 0 && i < rows-1){
							grid[i][j].addNeighbor(grid[i+1][j], k);
							grid[i+1][j].addNeighbor(grid[i][j], k-2);
						}else{
							grid[i][j].addNeighbor(null, k);
							if(i < rows-1){
								grid[i+1][j].addNeighbor(null, k-2);
							}
						}
						break;
					case 3:
						//west
						if(ew == 0 && j > 0){
							grid[i][j].addNeighbor(grid[i][j-1], k);
							grid[i][j-1].addNeighbor(grid[i][j], k-2);
						}else{
							grid[i][j].addNeighbor(null, k);
							if(j > 0){
								grid[i][j-1].addNeighbor(null, k-2);
							}
						}
						break;
						
					}
					System.out.println("    Neigh: " + grid[i][j].getNeighbor(k));
				}
			}
		}
		
		eastWest.close();
		northSouth.close();
		return grid;
	}
}
