// Link -> https://leetcode.com/problems/subsets/description/
import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Helper method that performs the backtracking to generate subsets
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset (tempList) to the result list
        result.add(new ArrayList<>(tempList));
        
        // Iterate over the elements starting from the index 'start'
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            tempList.add(nums[i]);
            // Recursively generate all subsets that include nums[i]
            backtrack(result, tempList, nums, i + 1);
            // Backtrack: remove the last element added to tempList to explore other subsets
            tempList.remove(tempList.size() - 1);
        }
    }

    // Main method to generate all subsets of the given array
    public List<List<Integer>> subsets(int[] nums) {
        // Result list to store all the subsets
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking with an empty temporary list and starting index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        // Return the generated list of subsets
        return result;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = sol.subsets(nums);
        System.out.println(subsets); // Expected output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }
}
