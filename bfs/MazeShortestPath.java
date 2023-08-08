// Import necessary libraries for the 'bfs' package
package bfs;

// Import required Java utility classes
import java.util.LinkedList;
import java.util.Queue;

// Class to find the shortest path in the maze using BFS approach
public class MazeShortestPath {

    // BFS approach to find the shortest path in the maze
    public static int bfsShortestPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Four possible directions: up, down, left, right

        // Create a queue to perform BFS traversal
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        maze[start[0]][start[1]] = -1; // Mark the starting cell as visited (used to store distance information)

        // Perform BFS traversal until the destination cell is reached
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // Check if the current cell is the destination cell
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return -maze[current[0]][current[1]]; // Return the shortest path (distance)
            }

            // Explore the four possible directions from the current cell
            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                // Check if the new position is within the maze boundaries and the cell is open (0)
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == 0) {
                    // Add the new cell to the queue and mark it as visited (store the distance)
                    queue.offer(new int[]{newRow, newCol});
                    maze[newRow][newCol] = maze[current[0]][current[1]] - 1;
                }
            }
        }

        return -1; // No path found to the destination cell
    }

    // Main method to test the 'bfsShortestPath' function
    public static void main(String[] args) {
        // Define the maze as a 2D array representing the grid
        int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };

        int[] start = {0, 4}; // Starting cell coordinates
        int[] destination = {4, 4}; // Destination cell coordinates

        // Find the shortest path using BFS and store the result in 'bfsShortestPath'
        int bfsShortestPath = bfsShortestPath(maze, start, destination);

        // Print the shortest path obtained from BFS
        System.out.println("Shortest path using BFS: " + bfsShortestPath);
    }
}
