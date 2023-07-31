package sorting;

import java.util.Arrays;

public class Heap {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Build a max-heap from the input array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Extract elements one by one from the max-heap and place them in the sorted array
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Heapify the reduced heap (excluding the sorted elements)
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            // Swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
