package topkelements;

import java.util.PriorityQueue;

public class MaxHeap {

    public static int[] findKLargestElements(int[] nums, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array and add the elements to the heap
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Convert the heap to an array of K largest elements in non-decreasing order
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 7, 2, 4, 6};
        int k = 3;

        int[] result = findKLargestElements(nums, k);

        System.out.println("Top " + k + " Largest Elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
