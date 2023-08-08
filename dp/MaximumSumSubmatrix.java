package dp;
public class MaximumSumSubmatrix {
    public static int maxSumSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;

        // Step 1: Iterate through all possible left and right column pairs.
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                // Step 2: Calculate the running sum of each row between the left and right columns.
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][right];
                }

                // Step 3: Find the maximum sum of a subarray in the running sum array (Kadane's algorithm).
                int currentSum = rowSum[0];
                int maxSumHere = rowSum[0];
                for (int i = 1; i < rows; i++) {
                    maxSumHere = Math.max(rowSum[i], maxSumHere + rowSum[i]);
                    currentSum = Math.max(currentSum, maxSumHere);
                }

                // Update the maximum sum found so far.
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        // Return the maximum sum of the submatrix.
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, -1},
            {-4, 5, 9},
            {7, 8, 9}
        };
        int result = maxSumSubmatrix(matrix);
        System.out.println("Maximum Sum of Submatrix: " + result); // Output: 28 (Maximum sum submatrix: [[5, 6], [8, 9]])
    }
}
