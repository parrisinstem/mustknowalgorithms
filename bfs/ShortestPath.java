// Import necessary libraries for the 'bfs' package
package bfs;

// Import required Java utility classes
import java.util.LinkedList;
import java.util.Queue;

// Class to find the shortest path in a binary matrix using BFS approach
public class ShortestPath {

    // Define the eight possible directions to explore from each cell in the matrix
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    // Method to find the shortest path in the binary matrix using BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Check if the starting or destination cell is an obstacle, if so, no path is possible
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // Create a queue to perform BFS traversal
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // Add the starting cell to the queue
        grid[0][0] = 1; // Mark the starting cell as visited and set the distance to 1

        // Perform BFS traversal until the destination cell is reached
        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int row = currentCell[0];
            int col = currentCell[1];

            // Check if the destination cell is reached, if yes, return the shortest distance
            if (row == n - 1 && col == n - 1) {
                return grid[row][col];
            }

            // Explore the eight possible directions from the current cell
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new position is within the matrix boundaries and the cell is open (0)
                if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 0) {
                    // Add the new cell to the queue and mark it as visited (set distance)
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = grid[row][col] + 1;
                }
            }
        }

        return -1; // No path found to the destination cell
    }

    // Helper method to check if a cell is within the matrix boundaries
    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    // Main method to test the 'shortestPathBinaryMatrix' function
    public static void main(String[] args) {
        // Define the binary matrix as a 2D array
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        // Create an instance of the 'ShortestPath' class
        ShortestPath solver = new ShortestPath();

        // Find the shortest path in the binary matrix using BFS and store the result in 'shortestPath'
        int shortestPath = solver.shortestPathBinaryMatrix(grid);

        // Print the shortest path obtained from BFS
        System.out.println("Shortest Path: " + shortestPath);
    }
}
