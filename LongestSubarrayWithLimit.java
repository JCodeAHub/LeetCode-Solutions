import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarrayWithLimit {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to maintain the indexes of the max and min elements in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0; // Left boundary of the sliding window
        int result = 0; // To keep track of the size of the longest subarray

        for (int right = 0; right < nums.length; right++) {
            // Maintain the max deque: pop elements from the back if they are less than the current element
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            // Add current element's index to the max deque
            maxDeque.addLast(right);

            // Maintain the min deque: pop elements from the back if they are greater than the current element
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            // Add current element's index to the min deque
            minDeque.addLast(right);

            // Check if the current window is valid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                // If not valid, move the left boundary to the right
                left++;
                // Remove elements out of the window from the deques
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }

            // Update the result with the size of the current valid window
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubarrayWithLimit solver = new LongestSubarrayWithLimit();
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println("The size of the longest subarray is: " + solver.longestSubarray(nums, limit));
    }
}
