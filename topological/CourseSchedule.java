package topological;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.putIfAbsent(course, new ArrayList<>());
            graph.get(course).add(prerequisiteCourse);
        }

        // Array to track the visited courses during DFS
        boolean[] visited = new boolean[numCourses];

        // Perform DFS for each course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(graph, visited, course)) {
                return false; // Cycle detected, cannot finish all courses
            }
        }

        return true; // No cycle found, can finish all courses
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false; // Cycle detected, not possible to finish all courses
        }

        visited[course] = true; // Mark the course as visited

        if (graph.containsKey(course)) {
            for (int prerequisiteCourse : graph.get(course)) {
                if (!dfs(graph, visited, prerequisiteCourse)) {
                    return false; // Cycle detected, not possible to finish all courses
                }
            }
        }

        visited[course] = false; // Backtrack and unmark the course as visited
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        boolean canFinishCourses = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinishCourses);
    }
}

