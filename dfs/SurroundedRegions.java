package dfs;

import java.util.Arrays;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from the border cells (first and last rows)
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col);
            }
        }

        // Start DFS from the border cells (first and last columns)
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        // Traverse the board and flip the remaining 'O's to 'X' and restore the visited 'O's to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
            return; // Base case: Out of bounds or not an 'O' cell
        }

        board[row][col] = 'V'; // Mark the cell as visited

        // Explore the neighboring cells in all four directions
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        SurroundedRegions solver = new SurroundedRegions();
        solver.solve(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
