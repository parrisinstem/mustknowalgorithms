// Package declaration for the 'searching.linear' package
package searching.linear;

// Class for linear search in an array
public class Array {
    // Method to perform linear search on an array and find the index of the target element
    public static int linearSearch(int[] arr, int target) {
        // Iterate through the array elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) { // Check if the current element matches the target
                return i; // If found, return the index of the target element
            }
        }
        return -1; // If the target element is not found, return -1
    }

    public static void main(String[] args) {
        int[] myArray = {10, 30, 50, 20, 40}; // Declare and initialize an array
        int targetElement = 20; // Target element to search in the array
        int result = linearSearch(myArray, targetElement); // Perform linear search
        if (result != -1) { // If the target element is found
            System.out.println("Element " + targetElement + " found at index " + result + ".");
        } else { // If the target element is not found
            System.out.println("Element not found.");
        }
    }
}
