package dp;

public class TileFloorFiller {

    public static int totalWaysToFillFloor(int N, int M) {
        // Initialize a 2D table dp of size (N + 1) * (M + 1) to store the number of ways to fill each cell.
        int[][] dp = new int[N + 1][M + 1];

        // Base cases - one way to fill an empty floor (when j = 0).
        for (int j = 0; j <= M; j++) {
            dp[0][j] = 1;
        }

        // Base cases - no way to fill a floor with no tile (when i > 0 and j = 0).
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 0;
        }

        // Calculate the number of ways to fill each cell iteratively.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // Number of ways to fill cell (i, j) is the sum of the number of ways to fill cell (i-1, j)
                // and the number of ways to fill cell (i, j-1).
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the total number of ways to fill the entire floor.
        return dp[N][M];
    }

    public static void main(String[] args) {
        int N = 2; // Number of rows in the floor
        int M = 3; // Number of columns in the floor

        int totalWays = totalWaysToFillFloor(N, M);
        System.out.println("Total number of ways to fill the floor: " + totalWays); // Output: Total number of ways to fill the floor: 10
    }
}
