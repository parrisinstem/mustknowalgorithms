package searching.binary;

public class BinarySearchArray {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50};
        int targetElement = 30;
        int result = binarySearch(myArray, targetElement);
        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result + ".");
        } else {
            System.out.println("Element not found.");
        }
    }
}
