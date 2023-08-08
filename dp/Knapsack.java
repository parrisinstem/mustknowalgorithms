package dp;

public class Knapsack {

    // Method to solve the 0/1 Knapsack problem using dynamic programming.
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1]; // Initialize a 2D array to store subproblem solutions.

        // Nested loops to fill up the 2D array using dynamic programming.
        for (int i = 1; i <= n; i++) { // Loop through each item.
            for (int j = 1; j <= capacity; j++) { // Loop through each possible capacity value.
                if (weights[i - 1] <= j) { // Check if the weight of the current item can fit in the current capacity.
                    // If the current item can be included in the knapsack, choose the maximum value between:
                    // (1) Including the current item and adding its value to the value of the subproblem solution
                    //     with the remaining capacity for the previous items.
                    // (2) Excluding the current item and taking the value of the subproblem solution
                    //     without considering the current item but with the same capacity.
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    // If the weight of the current item exceeds the current capacity, then it cannot be included.
                    // In this case, we take the value of the subproblem solution without considering the current item
                    // but with the same capacity.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The last cell of the 2D array contains the maximum value achievable in the knapsack with the given capacity.
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5}; // Array of weights of the items.
        int[] values = {6, 8, 10, 12}; // Array of values of the items.
        int capacity = 5; // Maximum capacity of the knapsack.
        int maxValue = knapsack(weights, values, capacity); // Call the knapsack method to get the maximum value.
        System.out.println("Maximum value in the knapsack: " + maxValue); // Print the maximum value achievable in the knapsack.
    }
}
