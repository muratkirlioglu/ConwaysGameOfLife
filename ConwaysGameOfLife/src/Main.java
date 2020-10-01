
public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		int[][] grid = 
			{ 		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
		        }; 

		PrintScreen(grid);
		System.out.println("++++++NEXTGEN++++++");
		
		int[][] nextGenGrid = NextGen(grid);
		PrintScreen(nextGenGrid);
		
		int numberOfIteration = 100;
		for (int i = 0; i < numberOfIteration; i++) {
			System.out.println("++++++NEXTGEN++++++");
			nextGenGrid = NextGen(nextGenGrid);
			PrintScreen(nextGenGrid);
		}
	}

	public static void PrintScreen(int[][] grid) {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1)
					System.out.print("*");
				else
					System.out.print(".");
			}
			System.out.println("");
		}
	}
	
	public static int CountNeighbours(int[][] grid, int row, int column) {
		int numberOfNeighbours = 0;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if((i != 0 || j != 0) && grid[row + i][column + j] == 1) {
					numberOfNeighbours++;
				}
			}
		}
		
		return numberOfNeighbours;
	}
	
	public static int[][] NextGen(int[][] grid) {
		int[][] nextGenGrid = new int[grid.length][grid[0].length];
		
		for (int i = 0; i < nextGenGrid.length; i++) {
			for (int j = 0; j < nextGenGrid[0].length; j++) {
				nextGenGrid[i][j] = grid[i][j];
			}
		}
		
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				int neighbours = CountNeighbours(grid, i, j);
				
				if(grid[i][j] == 1)
				{				
					if(neighbours < 2)
						nextGenGrid[i][j] = 0;
					
					else if(neighbours > 3)
						nextGenGrid[i][j] = 0;
				}
				else if(neighbours == 3)
				{
					nextGenGrid[i][j] = 1;
				}
			}
		}
		
		return nextGenGrid;
	}
}
