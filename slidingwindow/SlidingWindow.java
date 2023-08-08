package slidingwindow;

public class SlidingWindow {

    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[i - (k - 1)];
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int maxSum = maxSumSubarray(arr, k);
        System.out.println("Maximum sum subarray of size " + k + ": " + maxSum);
    }
}
