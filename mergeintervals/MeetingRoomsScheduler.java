package mergeintervals;

import java.util.*;

public class MeetingRoomsScheduler {
    public List<int[]> mergeIntervals(int[][] intervals) {
        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();

        // Initialize the current meeting to be the first meeting
        int[] currentMeeting = intervals[0];

        // Iterate through the sorted intervals and merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] nextMeeting = intervals[i];

            // Check if the current meeting overlaps with the next meeting
            if (currentMeeting[1] >= nextMeeting[0]) {
                // Merge the overlapping meetings by updating the end time
                currentMeeting[1] = Math.max(currentMeeting[1], nextMeeting[1]);
            } else {
                // The current meeting does not overlap with the next one, so add it to the result
                mergedIntervals.add(currentMeeting);
                // Update the current meeting to be the next meeting
                currentMeeting = nextMeeting;
            }
        }

        // Add the last meeting to the result
        mergedIntervals.add(currentMeeting);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        MeetingRoomsScheduler scheduler = new MeetingRoomsScheduler();
        int[][] meetings = {
            {900, 1000}, // Meeting 1
            {930, 1100}, // Meeting 2
            {1030, 1200}, // Meeting 3
            {1400, 1500}  // Meeting 4
        };

        List<int[]> mergedMeetings = scheduler.mergeIntervals(meetings);
        for (int[] meeting : mergedMeetings) {
            System.out.println(Arrays.toString(meeting));
        }
    }
}
