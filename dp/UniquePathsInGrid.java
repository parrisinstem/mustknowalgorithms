package dp;

public class UniquePathsInGrid {
    public static int uniquePaths(int[][] grid) {
        // Get the dimensions of the grid.
        int m = grid.length;
        int n = grid[0].length;

        // Create a 2D array to store the number of unique paths to reach each cell.
        int[][] dp = new int[m][n];

        // Initialize the number of unique paths for the first row and first column.
        // If the starting cell is not blocked, there is 1 unique path.
        dp[0][0] = (grid[0][0] == 0) ? 1 : 0; 
        for (int i = 1; i < m; i++) {
            // If a cell in the first column is not blocked, 
            //the number of paths is equal to the cell above it.
            dp[i][0] = (grid[i][0] == 0) ? dp[i - 1][0] : 0; 
        }
        for (int j = 1; j < n; j++) {
            // If a cell in the first row is not blocked, 
            //the number of paths is equal to the cell on its left.
            dp[0][j] = (grid[0][j] == 0) ? dp[0][j - 1] : 0; 
        }

        // Calculate the number of unique paths for each cell in the grid.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    // If the current cell is not blocked, 
                    //calculate the number of unique paths by adding the number of paths from 
                    //the cell above and the cell on its left.
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    // If the current cell is blocked, set the number of unique paths to 0.
                    dp[i][j] = 0;
                }
            }
        }

        // The bottom-right cell will have the total number of unique paths.
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int result = uniquePaths(grid);
        System.out.println("Number of Unique Paths: " + result); // Output: 2 (Two unique paths from (0,0) to (2,2)).
    }
}
