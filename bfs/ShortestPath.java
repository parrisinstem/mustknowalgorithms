package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // The start or destination cell is an obstacle, no path possible
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1; // Mark the starting cell as visited and set the distance to 1

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int row = currentCell[0];
            int col = currentCell[1];

            if (row == n - 1 && col == n - 1) {
                return grid[row][col]; // Reached the destination cell, return the shortest distance
            }

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = grid[row][col] + 1; // Mark as visited and update the distance
                }
            }
        }

        return -1; // No path found to the destination cell
    }

    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        ShortestPath solver = new ShortestPath();
        int shortestPath = solver.shortestPathBinaryMatrix(grid);
        System.out.println("Shortest Path: " + shortestPath);
    }
}
