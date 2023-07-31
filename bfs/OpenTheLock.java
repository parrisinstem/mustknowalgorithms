package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public int openLock(String current, String target, String[] deadEnds) {
        // Create a set to store the dead ends for efficient lookup
        Set<String> deadEndSet = new HashSet<>();
        for (String deadEnd : deadEnds) {
            deadEndSet.add(deadEnd);
        }

        // Create a queue for BFS traversal
        Queue<String> queue = new LinkedList<>();
        // Create a set to store visited combinations to avoid revisiting them
        Set<String> visited = new HashSet<>();

        // Add the starting combination to the queue and mark it as visited
        queue.offer(current);
        visited.add(current);

        int turns = 0; // Counter to keep track of the number of turns

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Traverse all the combinations at the current level
            for (int i = 0; i < size; i++) {
                String combination = queue.poll(); // Dequeue the front combination

                // Check if the current combination is equal to the target combination
                if (combination.equals(target)) {
                    return turns; // Return the number of turns to reach the target
                }

                // Generate all possible combinations by rotating each wheel forward and backward
                for (int j = 0; j < 4; j++) {
                    char wheel = combination.charAt(j); // Get the current wheel's digit

                    // Calculate the next combination by rotating the wheel forward
                    String nextCombinationForward = combination.substring(0, j) +
                            (wheel == '9' ? '0' : (char) (wheel + 1)) +
                            combination.substring(j + 1);

                    // Check if the next combination is valid and not a dead end or visited
                    if (!deadEndSet.contains(nextCombinationForward) && !visited.contains(nextCombinationForward)) {
                        queue.offer(nextCombinationForward); // Enqueue the next combination
                        visited.add(nextCombinationForward); // Mark the combination as visited
                    }

                    // Calculate the next combination by rotating the wheel backward
                    String nextCombinationBackward = combination.substring(0, j) +
                            (wheel == '0' ? '9' : (char) (wheel - 1)) +
                            combination.substring(j + 1);

                    // Check if the next combination is valid and not a dead end or visited
                    if (!deadEndSet.contains(nextCombinationBackward) && !visited.contains(nextCombinationBackward)) {
                        queue.offer(nextCombinationBackward); // Enqueue the next combination
                        visited.add(nextCombinationBackward); // Mark the combination as visited
                    }
                }
            }

            turns++; // Increment the number of turns after exploring all combinations at the current level
        }

        return -1; // No path found to the target combination, return -1
    }

    public static void main(String[] args) {
        String current = "0000";
        String target = "0202";
        String[] deadEnds = {"0201", "0101", "0102", "1212", "2002"};

        OpenTheLock solver = new OpenTheLock();
        int minTurns = solver.openLock(current, target, deadEnds);
        System.out.println("Minimum turns required: " + minTurns);
    }
}
