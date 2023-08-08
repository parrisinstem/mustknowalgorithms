// Package declaration for the 'mergeintervals' package
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class representing a Task with start time, end time, and load
class Task {
    int start;
    int end;
    int load;

    // Constructor to initialize the Task with start, end, and load values
    Task(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

// Class to find the maximum CPU load given a list of tasks
public class MaximumCPULoad {
    // Method to find the maximum CPU load
    public static int findMaxCPULoad(List<Task> tasks) {
        // Check if the list of tasks is null or empty, return 0 in such cases
        if (tasks == null || tasks.isEmpty()) {
            return 0;
        }

        // Sort tasks based on their start times in ascending order
        Collections.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));

        int maxCPULoad = 0; // Initialize the maximum CPU load as 0
        int currentCPULoad = 0; // Initialize the current CPU load as 0

        // Iterate through the sorted tasks
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i); // Get the current task

            // Check for overlap with the previous task (i.e., if currentTask's start time is less than the previous task's end time)
            if (i > 0 && currentTask.start < tasks.get(i - 1).end) {
                // Merge intervals and update current CPU load by adding the load of the current task
                currentCPULoad += currentTask.load;
            } else {
                // No overlap, update current CPU load to the load of the current task
                currentCPULoad = currentTask.load;
            }

            // Update the maximum CPU load seen so far by taking the maximum of the current CPU load and the previous maximum
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }

        return maxCPULoad; // Return the maximum CPU load
    }

    public static void main(String[] args) {
        // Create a list of tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 4, 3));
        tasks.add(new Task(2, 5, 4));
        tasks.add(new Task(7, 9, 6));

        // Find the maximum CPU load using the 'findMaxCPULoad' method
        int maxCPULoad = findMaxCPULoad(tasks);

        // Print the maximum CPU load to the console
        System.out.println("Maximum CPU Load: " + maxCPULoad);
    }
}
