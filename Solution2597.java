// Link -> https://leetcode.com/problems/the-number-of-beautiful-subsets/description/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int beautifulSubsetsCount = 0; // Variable to keep track of the number of beautiful subsets

    public int beautifulSubsets(int[] nums, int k) {
        // HashMap to keep track of the frequency of elements in the current subset
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Start the backtracking process from the first index
        backtrack(nums, k, 0, freqMap);
        // Return the total count of beautiful subsets
        return beautifulSubsetsCount;
    }

    private void backtrack(int[] nums, int k, int start, Map<Integer, Integer> freqMap) {
        // If the frequency map is not empty, we have a valid subset
        if (!freqMap.isEmpty()) {
            beautifulSubsetsCount++;
        }

        // Loop through each element starting from 'start' index to explore all subsets
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];

            // Check if adding 'num' would violate the beautiful condition
            if (freqMap.containsKey(num - k) || freqMap.containsKey(num + k)) {
                continue; // Skip this number if it creates a violation
            }

            // Include 'num' in the current subset by updating the frequency map
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // Recur to explore further subsets including the current number
            backtrack(nums, k, i + 1, freqMap);

            // Backtrack by removing 'num' from the current subset
            freqMap.put(num, freqMap.get(num) - 1);
            // Remove 'num' from the map if its count drops to zero
            if (freqMap.get(num) == 0) {
                freqMap.remove(num);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 4, 6}; // Sample input array
        int k = 2; // Sample value of k
        // Print the number of beautiful subsets
        System.out.println(sol.beautifulSubsets(nums, k));  // Output: 6
    }
}
