import java.util.*;

public class Solution3068 {
    // Method to calculate the maximum value sum
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        // Initialize variables to keep track of total sum, total difference, and minimum absolute difference
        long total = 0; // Total sum of nums
        long totalDiff = 0; // Total difference after applying XOR
        long minAbsDiff = Long.MAX_VALUE; // Minimum absolute difference between original and XOR values
        int positiveCount = 0; // Count of positive differences after applying XOR

        // Calculate total sum and differences for each element in nums
        for (int num : nums) {
            total += num; // Calculate total sum

            // Calculate the difference after applying XOR
            long diff = (num ^ k) - num;

            // Update total difference and positive count
            if (diff > 0) {
                totalDiff += diff; // Add positive difference to total difference
                positiveCount++; // Increment count of positive differences
            }

            // Update minimum absolute difference
            minAbsDiff = Math.min(minAbsDiff, Math.abs(diff));
        }

        // If the count of positive differences is odd, adjust the total difference
        if (positiveCount % 2 == 1) {
            totalDiff -= minAbsDiff; // Subtract the minimum absolute difference
        }

        // Return the maximum possible sum
        return total + totalDiff;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {24, 78, 1, 97, 44};
        int k = 6;
        int[][] edges = {{0, 2}, {1, 2}, {4, 2}};
        long result = maximumValueSum(nums, k, edges);
        System.out.println("Maximum Value Sum: " + result);
    }
}
