// Package declaration for the 'dfs' package

// Import required classes from Java standard library
import java.util.*;

// Class to find cells from which water can flow to both Pacific and Atlantic oceans using Depth-First Search (DFS)
public class PacificAtlantic {
    // Directions to explore neighboring cells: right, left, down, up
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Method to find cells from which water can flow to both Pacific and Atlantic oceans
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Create a list to store the result (cells reachable by both oceans)
        List<List<Integer>> result = new ArrayList<>();

        // Check if the input matrix is valid
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result; // Return an empty list if the matrix is null or has zero rows or columns
        }

        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create two boolean matrices to mark cells reachable by Pacific and Atlantic oceans
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Perform Depth-First Search (DFS) from the borders to find cells reachable by Pacific and Atlantic oceans
        for (int i = 0; i < rows; i++) {
            dfs(matrix, pacificReachable, i, 0); // DFS from the left border
            dfs(matrix, atlanticReachable, i, cols - 1); // DFS from the right border
        }
        for (int j = 0; j < cols; j++) {
            dfs(matrix, pacificReachable, 0, j); // DFS from the top border
            dfs(matrix, atlanticReachable, rows - 1, j); // DFS from the bottom border
        }

        // Find cells reachable by both Pacific and Atlantic oceans and add them to the result list
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result; // Return the list of cells reachable by both Pacific and Atlantic oceans
    }

    // Helper method for recursive Depth-First Search (DFS) to mark reachable cells from a given cell
    private void dfs(int[][] matrix, boolean[][] reachable, int row, int col) {
        // Check if the cell is already marked as reachable, if yes, return (base case)
        if (reachable[row][col]) {
            return;
        }

        // Mark the current cell as reachable
        reachable[row][col] = true;

        // Explore neighboring cells in all four directions
        for (int[] dir : directions) {
            int newRow = row + dir[0]; // Calculate the row index of the neighboring cell
            int newCol = col + dir[1]; // Calculate the column index of the neighboring cell

            // Check if the neighboring cell is within the matrix bounds and has equal or lower height
            if (newRow >= 0 && newRow < matrix.length &&
                newCol >= 0 && newCol < matrix[0].length &&
                matrix[newRow][newCol] >= matrix[row][col]) {
                dfs(matrix, reachable, newRow, newCol); // Recursively visit the neighboring cell
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the PacificAtlantic class to find cells reachable by both oceans
        PacificAtlantic solution = new PacificAtlantic();

        // Sample 2D matrix representing the height of each cell
        int[][] matrix = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        // Find cells reachable by both Pacific and Atlantic oceans using the 'pacificAtlantic' method
        List<List<Integer>> result = solution.pacificAtlantic(matrix);

        // Print the cells reachable by both Pacific and Atlantic oceans
        System.out.println("Cells reachable by both Pacific and Atlantic oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
