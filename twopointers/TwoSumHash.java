import java.util.HashMap;
import java.util.Map;

public class TwoSumHash {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            numToIndex.put(nums[i], i);
        }

        // If no solution is found, return an empty array or throw an exception.
        // In this case, I'm returning null to indicate no solution found.
        return null;
    }

    // Example usage:
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSumHash twoSum = new TwoSumHash();
        int[] result = twoSum.twoSum(nums, target);
        if (result != null) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
            // Output: [0, 1]
        } else {
            System.out.println("No solution found.");
        }
    }
}

//TIME O(N)
//SPACE O(N)