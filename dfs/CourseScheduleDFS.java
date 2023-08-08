// Package declaration for the 'dfs' package

// Import necessary Java utility classes
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Class to check if a course schedule can be completed without violating any prerequisites using Depth-First Search (DFS)
class CourseScheduleDFS {
    // Method to check if a course schedule can be completed without violating prerequisites
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // LIST: Initialize an adjacency list to represent the course prerequisites relationships
        List<List<Integer>> adjList = new ArrayList<>();

        // Loop to create an empty list for each course in the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Loop to populate the adjacency list with the prerequisites for each course
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            // LIST: Add the prerequisite course to the list of courses that depend on the current course
            adjList.get(course).add(prerequisiteCourse);
        }

        // Create an array to keep track of visited courses during DFS
        boolean[] visited = new boolean[numCourses];

        // Perform DFS for each course recursively
        for (int i = 0; i < numCourses; i++) {
            // Check if the course is not visited and has a cycle (prerequisite dependency loop)
            if (!visited[i] && hasCycle(i, adjList, visited)) {
                return false; // Cannot finish the course schedule
            }
        }

        return true; // Course schedule can be completed without violating any prerequisites
    }

    // Helper method to perform DFS to detect a cycle in the course prerequisites graph
    private boolean hasCycle(int course, List<List<Integer>> adjList, boolean[] visited) {
        // If the course is already visited, it indicates a cycle (prerequisite dependency loop)
        if (visited[course]) {
            return true; // Detected a cycle
        }

        visited[course] = true; // Mark the course as visited

        // Recursive loop to check the neighbors of the current course
        for (int neighbor : adjList.get(course)) {
            if (hasCycle(neighbor, adjList, visited)) {
                return true; // Recursive call returns true if a cycle is found in any of the neighbors
            }
        }

        visited[course] = false; // Mark the course as not visited after processing its neighbors
        return false; // No cycle found for the current course
    }
}
