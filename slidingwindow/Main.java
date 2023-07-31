package slidingwindow;

public class Main {

    public static void main(String[] args) {
        // Test maxSumSubarray
        int[] nums1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        int maxSum1 = SlidingWindow.maxSumSubarray(nums1, k1);
        System.out.println("Maximum sum of subarray with size " + k1 + ": " + maxSum1);

        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int k2 = 4;
        int maxSum2 = SlidingWindow.maxSumSubarray(nums2, k2);
        System.out.println("Maximum sum of subarray with size " + k2 + ": " + maxSum2);

        // Test minWindowSubstring
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String minWindow1 = MinSlidingWindow.minWindowSubstring(s1, t1);
        System.out.println("Minimum window substring: " + minWindow1);

        String s2 = "aab";
        String t2 = "aab";
        String minWindow2 = MinSlidingWindow.minWindowSubstring(s2, t2);
        System.out.println("Minimum window substring: " + minWindow2);
    }
}
