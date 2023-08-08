package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    // Binary search algorithm to find the index of the target book in the catalog
    public static int binarySearch(List<String> catalog, String targetBook) {
        int left = 0; // Left pointer to the start of the catalog
        int right = catalog.size() - 1; // Right pointer to the end of the catalog

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            String midBook = catalog.get(mid); // Get the book at the middle index

            // Check if the middle book matches the target book
            if (midBook.equals(targetBook)) {
                return mid; // Return the index of the target book
            }

            // If the target book comes before the middle book in the alphabet
            if (targetBook.compareTo(midBook) < 0) {
                right = mid - 1; // Update the right pointer to focus on the left half
            } else {
                left = mid + 1; // Update the left pointer to focus on the right half
            }
        }

        return -1; // Target book not found in the catalog
    }

    public static void main(String[] args) {
        // Sample sorted library catalog (alphabetically by book title)
        List<String> catalog = new ArrayList<>();
        catalog.add("Alice in Wonderland");
        catalog.add("Brave New World");
        catalog.add("Harry Potter and the Philosopher's Stone");
        catalog.add("Lord of the Rings");
        catalog.add("To Kill a Mockingbird");

        String targetBook = "Lord of the Rings"; // Book to search for

        // Use binary search to find the index of the target book in the catalog
        int index = binarySearch(catalog, targetBook);

        if (index != -1) {
            System.out.println("The book '" + targetBook + "' is found at index " + index);
        } else {
            System.out.println("The book '" + targetBook + "' is not found in the catalog.");
        }
    }
}

