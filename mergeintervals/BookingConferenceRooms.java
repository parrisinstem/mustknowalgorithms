package mergeintervals;
import java.util.*;

public class BookingConferenceRooms {
    public int[][] mergeBookings(int[][] bookings) {
        // Sort the bookings for each room based on their start times
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]);

        List<int[]> mergedBookings = new ArrayList<>();
        int[] currentBooking = bookings[0];

        // Iterate through each room's bookings and merge overlapping bookings
        for (int i = 1; i < bookings.length; i++) {
            int[] nextBooking = bookings[i];

            // Check if the current booking overlaps with the next booking
            if (currentBooking[1] >= nextBooking[0]) {
                // Merge the overlapping bookings by updating the end time
                currentBooking[1] = Math.max(currentBooking[1], nextBooking[1]);
            } else {
                // The current booking does not overlap with the next one, so add it to the result
                mergedBookings.add(currentBooking);
                // Update the current booking to be the next booking
                currentBooking = nextBooking;
            }
        }

        // Add the last booking to the result
        mergedBookings.add(currentBooking);

        return mergedBookings.toArray(new int[mergedBookings.size()][]);
    }

    public static void main(String[] args) {
        BookingConferenceRooms scheduler = new BookingConferenceRooms();
        int[][] room1Bookings = {{900, 1030}, {1100, 1230}, {1400, 1600}};
        int[][] room2Bookings = {{930, 1030}, {1130, 1300}, {1500, 1700}};

        int[][] bookings = {room1Bookings, room2Bookings};

        int[][] mergedRoom1Bookings = scheduler.mergeBookings(room1Bookings);
        int[][] mergedRoom2Bookings = scheduler.mergeBookings(room2Bookings);

        System.out.println("Merged Bookings for Room 1:");
        for (int[] booking : mergedRoom1Bookings) {
            System.out.println(Arrays.toString(booking));
        }

        System.out.println("\nMerged Bookings for Room 2:");
        for (int[] booking : mergedRoom2Bookings) {
            System.out.println(Arrays.toString(booking));
        }
    }
}
