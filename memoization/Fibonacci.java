// Package declaration for the 'memoization' package

import java.util.HashMap;
import java.util.Map;

// Class to calculate Fibonacci numbers using memoization technique
public class Fibonacci {

    // HashMap to store previously calculated Fibonacci numbers for memoization
    private static Map<Integer, Long> memo = new HashMap<>();

    // Method to calculate the nth Fibonacci number
    public static long fibonacci(int n) {
        // Base case: If 'n' is less than or equal to 1, return 'n'
        if (n <= 1) {
            return n;
        }

        // Check if the result for 'n' is already memoized, return it
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // If the result for 'n' is not in the memo, calculate it using recursion
        long result = fibonacci(n - 1) + fibonacci(n - 2);

        // Store the calculated Fibonacci number for 'n' in the memo to avoid redundant calculations
        memo.put(n, result);

        return result; // Return the Fibonacci number for 'n'
    }

    public static void main(String[] args) {
        int n = 50;
        // Calculate the 50th Fibonacci number
        long fibN = fibonacci(n);

        // Print the result to the console
        System.out.println("Fibonacci(" + n + ") = " + fibN);
    }
}
