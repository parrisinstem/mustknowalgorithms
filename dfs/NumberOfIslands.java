// Package declaration for the 'dfs' package

// Class to find the number of islands in a 2D grid using Depth-First Search (DFS)
public class NumberOfIslands {

    // Method to find the number of islands in the grid
    public int numIslands(char[][] grid) {
        // Check if the grid is null or empty
        if (grid == null || grid.length == 0) {
            return 0; // No islands found in an empty grid
        }

        // Get the number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0; // Initialize the island count to zero

        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If a land cell is found ('1'), increment the island count and perform DFS to mark all connected land cells
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j); // Perform Depth-First Search to mark all connected land cells as visited ('0')
                }
            }
        }

        return count; // Return the total number of islands found
    }

    // Helper method to perform Depth-First Search (DFS) from a given cell position (row, col)
    private void dfs(char[][] grid, int row, int col) {
        // Get the number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: If the cell is out of bounds or a water cell ('0'), return
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        // Mark the current cell as visited (land) by changing its value to '0'
        grid[row][col] = '0';

        // Recursively explore the neighboring cells in all four directions (up, down, left, right)
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    public static void main(String[] args) {
        // Two sample grids representing islands in a 2D grid
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        // Create an instance of the NumberOfIslands class to find the number of islands
        NumberOfIslands solver = new NumberOfIslands();

        // Find the number of islands in each grid using the 'numIslands' method
        int numIslands1 = solver.numIslands(grid1);
        System.out.println("Number of Islands in grid1: " + numIslands1);

        int numIslands2 = solver.numIslands(grid2);
        System.out.println("Number of Islands in grid2: " + numIslands2);
    }
}
