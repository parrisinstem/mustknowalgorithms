package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on their start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Non-overlapping interval, add the current merged interval to the result list
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last merged interval to the result list
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged1 = merge(intervals1);
        System.out.println("Merged Intervals 1: " + Arrays.deepToString(merged1));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] merged2 = merge(intervals2);
        System.out.println("Merged Intervals 2: " + Arrays.deepToString(merged2));
    }
}
