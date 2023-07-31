import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right]; // Update the next non-duplicate element
            }
        }

        return left + 1; // Length of the modified array without duplicates
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3, 4, 4, 5, 5};
        int newLength1 = removeDuplicates(nums1);
        // int[] modifiedArray1 = Arrays.copyOf(nums1, newLength1);
        // System.out.print("Output 1: [");
        // for (int i = 0; i < modifiedArray1.length; i++) {
        //     System.out.print(modifiedArray1[i]);
        //     if (i != modifiedArray1.length - 1) {
        //         System.out.print(", ");
        //     }
        // }
        // System.out.println("]");

        // int[] nums2 = {10, 10, 20, 30, 30, 40, 40, 50};
        // int newLength2 = removeDuplicates(nums2);
        // int[] modifiedArray2 = Arrays.copyOf(nums2, newLength2);
        // System.out.print("Output 2: [");
        // for (int i = 0; i < modifiedArray2.length; i++) {
        //     System.out.print(modifiedArray2[i]);
        //     if (i != modifiedArray2.length - 1) {
        //         System.out.print(", ");
        //     }
        // }
        // System.out.println("]");
        System.out.println("Output 1: " + Arrays.toString(Arrays.copyOf(nums1, newLength1)));

        int[] nums2 = {10, 10, 20, 30, 30, 40, 40, 50};
        int newLength2 = removeDuplicates(nums2);
        System.out.println("Output 2: " + Arrays.toString(Arrays.copyOf(nums2, newLength2)));
    }
}

//Time O(N)
//Space O(N)