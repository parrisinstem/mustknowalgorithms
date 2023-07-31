package searching.linear;

public class Array {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myArray = {10, 30, 50, 20, 40};
        int targetElement = 20;
        int result = linearSearch(myArray, targetElement);
        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result + ".");
        } else {
            System.out.println("Element not found.");
        }
    }
}
