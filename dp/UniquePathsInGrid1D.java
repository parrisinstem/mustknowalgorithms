package dp;

public class UniquePathsInGrid1D {
    public static int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n]; // Use a 1D array to store the number of unique paths for each column.

        // Initialize the number of unique paths for the first column.
        dp[0] = (grid[0][0] == 0) ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = 0; // If the current cell is blocked, set the number of unique paths to 0.
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // Calculate the number of unique paths by adding the number of paths from the cell above and the cell on its left.
                }
            }
        }

        // The last element of the array will have the total number of unique paths.
        return dp[n - 1];
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
