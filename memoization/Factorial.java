// Package declaration for the 'memoization' package

import java.util.HashMap;

// Class to calculate factorial using memoization technique
public class Factorial {

    // HashMap to store previously calculated factorials for memoization
    private static HashMap<Integer, Long> memo = new HashMap<>();

    // Method to calculate the factorial of a non-negative integer 'n'
    public static long factorial(int n) {
        // Base case: If 'n' is negative, throw an exception
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }

        // Base case: If 'n' is 0 or 1, factorial is 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // If the factorial for 'n' is already calculated and present in the memo, return it
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // If the factorial for 'n' is not in the memo, calculate it using recursion
        long factN = n * factorial(n - 1);

        // Store the calculated factorial for 'n' in the memo to avoid redundant calculations
        memo.put(n, factN);

        return factN; // Return the factorial of 'n'
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("The factorial of " + n + " is: " + factorial(n));
    }
}
