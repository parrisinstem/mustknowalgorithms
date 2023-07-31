package mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Task {
    int start;
    int end;
    int load;

    Task(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return 0;
        }

        // Sort tasks based on their start times
        Collections.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));

        int maxCPULoad = 0;
        int currentCPULoad = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);

            // Check for overlap with the previous task
            if (i > 0 && currentTask.start < tasks.get(i - 1).end) {
                // Merge intervals and update current CPU load
                currentCPULoad += currentTask.load;
            } else {
                // No overlap, update current CPU load
                currentCPULoad = currentTask.load;
            }

            // Update the maximum CPU load seen so far
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }

        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 4, 3));
        tasks.add(new Task(2, 5, 4));
        tasks.add(new Task(7, 9, 6));

        int maxCPULoad = findMaxCPULoad(tasks);
        System.out.println("Maximum CPU Load: " + maxCPULoad);
    }
}
