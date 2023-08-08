package twopointers;
public class TrappingWater {
    public static int trapWater(int[] height) {
        // Initialize left and right pointers and variables to store max heights.
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        // Continue until left and right pointers meet.
        while (left < right) {
            // Calculate the max height on the left side.
            if (height[left] > leftMax) {
                leftMax = height[left];
            }

            // Calculate the max height on the right side.
            if (height[right] > rightMax) {
                rightMax = height[right];
            }

            // Calculate trapped water at the current position.
            if (leftMax < rightMax) {
                trappedWater += leftMax - height[left];
                left++;
            } else {
                trappedWater += rightMax - height[right];
                right--;
            }
        }

        return trappedWater;
    }

    // Example usage:
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trapWater(height);
        System.out.println("Total trapped water: " + result); // Output: 6
    }
}
