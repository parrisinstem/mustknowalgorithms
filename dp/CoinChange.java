// Package declaration for the 'dp' package

// Import required class from Java standard library
import java.util.Arrays;

// Class to find the minimum number of coins needed for a given amount using Dynamic Programming (DP)
public class CoinChange {

    // Method to find the minimum number of coins needed to make a given amount
    public static int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum number of coins needed for each amount from 0 to 'amount'
        int[] dp = new int[amount + 1];

        // Initialize the 'dp' array with 'amount + 1' (a value greater than the maximum possible number of coins)
        Arrays.fill(dp, amount + 1);

        // The number of coins needed to make 0 amount is 0
        dp[0] = 0;

        // Iterate through each coin in the 'coins' array
        for (int coin : coins) {
            // Starting from 'coin', update the minimum number of coins needed for each amount up to 'amount'
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // Check if the minimum number of coins needed for 'amount' is greater than 'amount'
        // If yes, return -1 (impossible to make the amount using the given coins), else return the result
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Main method to demonstrate the usage of the 'coinChange' method
    public static void main(String[] args) {
        // Sample coin denominations and amount
        int[] coins = {1, 5, 10, 25};
        int amount = 30;

        // Find the minimum number of coins needed to make the given amount using the 'coinChange' method
        int minCoins = coinChange(coins, amount);

        // Print the result
        System.out.println("Minimum number of coins needed: " + minCoins); // Output: 2
    }
}
