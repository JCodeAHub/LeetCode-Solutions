import java.util.Arrays;

public class Solution {
    public int specialArray(int[] nums) {
        // Sort the array to facilitate counting numbers >= x
        Arrays.sort(nums);
        
        int n = nums.length;
        
        // Iterate through possible values of x from 1 to n
        for (int x = 1; x <= n; x++) {
            // Find the first index where the number is >= x
            int index = n - x;
            
            // Check if nums[index] is >= x
            // Also, check if nums[index - 1] < x (if index is within bounds)
            if (nums[index] >= x && (index == 0 || nums[index - 1] < x)) {
                return x;
            }
        }
        
        // If no such x is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example case
        int[] nums = {0, 0};
        System.out.println(sol.specialArray(nums));  // Output: -1
    }
}
