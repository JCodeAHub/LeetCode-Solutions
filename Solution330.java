public class Solution330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long miss = 1; // smallest number we can't form yet
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // if nums[i] can be used to form new sums up to miss
                miss += nums[i];
                i++;
            } else {
                // patch the array with 'miss'
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }

    public static void main(String[] args) {
        Solution330 solution = new Solution330();
        int[] nums = {1, 3};
        int n = 6;
        System.out.println(solution.minPatches(nums, n)); // Output: 1
    }
}
