import java.util.HashMap;

public class SubarraySumDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        // HashMap to store the frequency of prefix sum remainders
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        // Initialize with remainder 0, as a sum of 0 is always divisible by k
        remainderCount.put(0, 1);
        
        int prefixSum = 0; // This will store the cumulative sum of elements
        int count = 0; // This will store the number of valid subarrays

        for (int num : nums) {
            prefixSum += num; // Update the cumulative sum
            int remainder = prefixSum % k; // Find the remainder of the cumulative sum with k

            // Adjust remainder to be positive if it's negative
            if (remainder < 0) {
                remainder += k;
            }

            // If this remainder has been seen before, there are remainderCount.get(remainder) subarrays ending here
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            // Update the count of this remainder in the hashmap
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count; // Return the total count of subarrays with sum divisible by k
    }

    public static void main(String[] args) {
        SubarraySumDivisibleByK solver = new SubarraySumDivisibleByK();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = solver.subarraysDivByK(nums, k);
        System.out.println("Number of subarrays with sum divisible by " + k + ": " + result); // Output should be 7
    }
}
