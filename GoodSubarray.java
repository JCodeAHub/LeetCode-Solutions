import java.util.HashMap;

public class GoodSubarray {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Initialize a hashmap to store the modulus and the earliest index it appears
        HashMap<Integer, Integer> modMap = new HashMap<>();
        // Start by adding a base case for the prefix sum modulo
        modMap.put(0, -1);
        
        // Initialize the running sum
        int runningSum = 0;
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            // Update the running sum
            runningSum += nums[i];
            
            // Compute the current modulus
            int mod = runningSum % k;
            
            // Adjust negative modulus to be positive
            if (mod < 0) {
                mod += k;
            }
            
            // If this modulus has been seen before, check the subarray length
            if (modMap.containsKey(mod)) {
                // Get the previous index of this modulus
                int prevIndex = modMap.get(mod);
                
                // Check if the subarray length is at least 2
                if (i - prevIndex > 1) {
                    return true;
                }
            } else {
                // Otherwise, store the modulus and its index
                modMap.put(mod, i);
            }
        }
        
        // If no good subarray found, return false
        return false;
    }

    public static void main(String[] args) {
        // Create an instance of the solution class
        GoodSubarray solution = new GoodSubarray();
        
        // Test case 1
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(solution.checkSubarraySum(nums1, k1)); // Output: true
        
        // Test case 2
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 13;
        System.out.println(solution.checkSubarraySum(nums2, k2)); // Output: false
    }
}
