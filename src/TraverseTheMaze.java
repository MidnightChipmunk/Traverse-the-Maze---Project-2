import java.io.FileNotFoundException;
import java.util.EmptyStackException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TraverseTheMaze {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		Maze maze = new Maze((MazeBuilder.loadMazeFile()));
		
		maze.findPath(maze.getCellAt(0, 0));
		
		try{
			if(maze.getStack().size() > 0){
				JOptionPane.showMessageDialog(new JFrame(), "Path found, coordinates in the consoles!");
				GenericNode.reverseData(maze.getStack().top);
				maze.getStack().display();
				maze.display();
				maze.neighbors();
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(new JFrame(), "No path found!");
		}
	}
}
