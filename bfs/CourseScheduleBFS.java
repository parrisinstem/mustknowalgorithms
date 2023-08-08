// Import necessary libraries for the 'bfs' package
package bfs;

// Import required Java utility classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Class to check if course schedules can be completed using BFS approach
class CourseScheduleBFS {

    // Method to check if courses can be finished based on prerequisites
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create an adjacency list to represent course prerequisites
        List<List<Integer>> adjList = new ArrayList<>();

        // Create an adjacency matrix to represent course prerequisites
        int[][] adjMatrix = new int[numCourses][numCourses];

        // Create a HashMap to store the adjacency list
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            // Initialize each entry in the adjacency list with an empty ArrayList
            adjList.add(new ArrayList<>());
            // Also add the entry to the HashMap with an empty ArrayList
            adjListMap.put(i, new ArrayList<>());
        }

        // Populate the adjacency list and adjacency matrix based on prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            // Add the prerequisite course to the adjacency list of the current course
            adjList.get(course).add(prerequisiteCourse);

            // Mark the entry in the adjacency matrix to indicate the prerequisite relationship
            adjMatrix[course][prerequisiteCourse] = 1;
        }

        // Create an array to store the in-degree of each course
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            inDegree[course]++;
        }

        // Perform BFS using Queue to check if all courses can be completed
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // If a course has no prerequisites (in-degree is 0), add it to the queue
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Variable to count the number of courses that can be completed
        int count = 0;

        // Start BFS traversal
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++; // Increment the count for each course processed

            // For each neighbor of the current course, reduce its in-degree
            // and add it to the queue if its in-degree becomes 0
            for (int neighbor : adjList.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Return true if the number of courses that can be completed is equal to the total number of courses
        return count == numCourses;
    }
}
