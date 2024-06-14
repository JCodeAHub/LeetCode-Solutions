import java.util.Arrays;

public class MinimumIncrementToMakeUnique {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] + 1 - nums[i]; // Calculate the necessary increment
                nums[i] = nums[i - 1] + 1; // Increment to make unique
                moves += increment; // Add the increment to the total moves
            }
        }
        
        return moves;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        System.out.println(minIncrementForUnique(nums1)); // Output: 1
        
        int[] nums2 = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(nums2)); // Output: 6
    }
}
