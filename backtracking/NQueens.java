package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private List<List<String>> result;
    private int[] queens; // Store column index of queens for each row
    private boolean[] colUsed; // Track used columns
    private boolean[] leftDiagonal; // Track used left diagonals
    private boolean[] rightDiagonal; // Track used right diagonals

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        queens = new int[n];
        colUsed = new boolean[n];
        leftDiagonal = new boolean[2 * n - 1];
        rightDiagonal = new boolean[2 * n - 1];
        solveNQueensHelper(n, 0);
        return result;
    }

    // Helper function to recursively find valid placements for queens
    private void solveNQueensHelper(int n, int row) {
        // Base case: all rows have been explored, so a valid solution is found
        if (row == n) {
            result.add(constructSolution(n));
            return;
        }

        // Try each column in the current row to find a safe placement for the queen
        for (int col = 0; col < n; col++) {
            if (!colUsed[col] && !leftDiagonal[row + col] && !rightDiagonal[n - 1 + row - col]) {
                // Place a queen in the current cell
                queens[row] = col;
                colUsed[col] = true;
                leftDiagonal[row + col] = true;
                rightDiagonal[n - 1 + row - col] = true;

                // Recursively proceed to the next row
                solveNQueensHelper(n, row + 1);

                // Backtrack: remove the queen from the current cell
                colUsed[col] = false;
                leftDiagonal[row + col] = false;
                rightDiagonal[n - 1 + row - col] = false;
            }
        }
    }

    // Function to construct the solution representation for a valid placement
    private List<String> constructSolution(int n) {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(queens[row] == col ? "Q" : ".");
            }
            solution.add(sb.toString());
        }
        return solution;
    }
}
