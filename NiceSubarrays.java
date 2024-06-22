import java.util.HashMap;

public class NiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        // This map will store the count of occurrences of the number of odd numbers seen so far
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // Initial count of 0 odd numbers

        int oddCount = 0; // This will keep track of the number of odd numbers in the current prefix
        int result = 0;   // This will store the final count of nice subarrays

        for (int num : nums) {
            // Increment oddCount if the current number is odd
            if (num % 2 != 0) {
                oddCount++;
            }

            // Check if there has been a prefix with (oddCount - k) odd numbers
            if (countMap.containsKey(oddCount - k)) {
                // If so, add the count of such prefixes to the result
                result += countMap.get(oddCount - k);
            }

            // Update the count of the current number of odd numbers seen so far
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        NiceSubarrays solution = new NiceSubarrays();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println("Number of nice subarrays: " + solution.numberOfSubarrays(nums, k)); // Output: 2
    }
}
