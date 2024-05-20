public class Solution1863 {
    public int subsetXORSum(int[] nums) {
        // Total sum of all XOR values of all subsets
        int[] result = new int[1];
        // Start backtracking from index 0 with initial XOR value 0
        backtrack(nums, 0, 0, result);
        return result[0];
    }
    
    private void backtrack(int[] nums, int index, int currentXOR, int[] result) {
        // If we've considered all elements, add the current XOR to the result
        if (index == nums.length) {
            result[0] += currentXOR;
            return;
        }
        
        // Include the current element in the subset (update currentXOR)
        backtrack(nums, index + 1, currentXOR ^ nums[index], result);
        
        // Exclude the current element from the subset (keep currentXOR unchanged)
        backtrack(nums, index + 1, currentXOR, result);
    }

    public static void main(String[] args) {
        // Example usage
        Solution1863 solution = new Solution1863();
        
        int[] nums1 = {1, 3};
        System.out.println("Input: [1, 3]");
        System.out.println("Output: " + solution.subsetXORSum(nums1)); // Output: 6

        int[] nums2 = {5, 1, 6};
        System.out.println("Input: [5, 1, 6]");
        System.out.println("Output: " + solution.subsetXORSum(nums2)); // Output: 28

        int[] nums3 = {2, 4, 6};
        System.out.println("Input: [2, 4, 6]");
        System.out.println("Output: " + solution.subsetXORSum(nums3)); // Output: 28
    }
}
