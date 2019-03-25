import java.io.FileNotFoundException;
import java.util.EmptyStackException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TraverseTheMaze {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		Maze maze = new Maze(MazeBuilder.loadMazeFile());
		
		maze.findPath(maze.getCellAt(0,0));
		displayMaze(maze);

		maze = new Maze(MazeBuilder.loadMazeRandom());
		maze.findPath(maze.getCellAt(0,0));
		displayMaze(maze);
	}
	
	public static void displayMaze(Maze maze) {
		if(!maze.getStack().isEmpty()) {
			if(maze.getStack().size() > 0){
				GenericNode.reverseData(maze.getStack().top);
				maze.getStack().display();
				maze.display();
				JOptionPane.showMessageDialog(new JFrame(), "Path found, coordinates in the consoles!");
			}
		}else{
			JOptionPane.showMessageDialog(new JFrame(), "No path found!");
		}
	}
}
