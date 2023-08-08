// Package declaration for the 'dfs' package

// Import required class from Java standard library
import java.util.Arrays;

// Class to solve the 'Surrounded Regions' problem using Depth-First Search (DFS)
public class SurroundedRegions {

    // Method to solve the 'Surrounded Regions' problem
    public void solve(char[][] board) {
        // Check if the input board is null or has zero rows
        if (board == null || board.length == 0) {
            return; // Return without further processing
        }

        // Get the number of rows and columns in the board
        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from the border cells (first and last rows)
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col); // DFS from the top border
            }
            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col); // DFS from the bottom border
            }
        }

        // Start DFS from the border cells (first and last columns)
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0); // DFS from the left border
            }
            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1); // DFS from the right border
            }
        }

        // Traverse the board and flip the remaining 'O's to 'X' and restore the visited 'O's to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Flip 'O' cells to 'X'
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O'; // Restore visited 'O' cells to 'O'
                }
            }
        }
    }

    // Helper method for recursive Depth-First Search (DFS) to mark visited cells from a given cell
    private void dfs(char[][] board, int row, int col) {
        // Get the number of rows and columns in the board
        int rows = board.length;
        int cols = board[0].length;

        // Check if the cell is out of bounds or not an 'O' cell, if yes, return (base case)
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
            return;
        }

        // Mark the current cell as visited (denoted by 'V')
        board[row][col] = 'V';

        // Explore neighboring cells in all four directions using recursive DFS
        dfs(board, row - 1, col); // Up
        dfs(board, row + 1, col); // Down
        dfs(board, row, col - 1); // Left
        dfs(board, row, col + 1); // Right
    }

    public static void main(String[] args) {
        // Sample 2D board representing 'X' and 'O' cells
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        // Create an instance of the SurroundedRegions class
        SurroundedRegions solver = new SurroundedRegions();

        // Solve the 'Surrounded Regions' problem using the 'solve' method
        solver.solve(board);

        // Print the resulting board after solving the problem
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
