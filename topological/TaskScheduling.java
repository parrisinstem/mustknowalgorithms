package topological;
import java.util.*;

public class TaskScheduling {
    public static List<Integer> taskScheduling(int numTasks, int[][] dependencies) {
        // Create an adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numTasks];

        // Initialize in-degree array and adjacency list
        for (int i = 0; i < numTasks; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Fill in-degree and adjacency list based on dependencies
        for (int[] dependency : dependencies) {
            int task = dependency[0];
            int prerequisite = dependency[1];
            graph.get(prerequisite).add(task);
            inDegree[task]++;
        }

        // Find tasks with no prerequisites (in-degree = 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numTasks; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentTask = queue.poll();
            topologicalOrder.add(currentTask);

            for (int dependentTask : graph.get(currentTask)) {
                inDegree[dependentTask]--;
                if (inDegree[dependentTask] == 0) {
                    queue.add(dependentTask);
                }
            }
        }

        // If all tasks are not included in the topological order, there is a cycle
        if (topologicalOrder.size() != numTasks) {
            return null;
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        int numTasks = 5;
        int[][] dependencies = {{1, 0}, {2, 1}, {3, 2}, {4, 1}, {4, 3}};

        List<Integer> result = taskScheduling(numTasks, dependencies);
        if (result == null) {
            System.out.println("No valid topological order (cycle detected).");
        } else {
            System.out.println("Topological Order: " + result);
        }
    }
}
