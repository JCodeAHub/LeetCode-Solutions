import java.util.LinkedList;
import java.util.Queue;

public class MinimumKBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipCount = 0;
        Queue<Integer> flipIndices = new LinkedList<>(); // Queue to track the flip indices

        for (int i = 0; i < n; i++) {
            // Remove indices from the queue that are out of the range of the current flip window
            if (!flipIndices.isEmpty() && flipIndices.peek() + k <= i) {
                flipIndices.poll();
            }

            // If the current element needs to be flipped
            if ((nums[i] == 0 && flipIndices.size() % 2 == 0) || (nums[i] == 1 && flipIndices.size() % 2 == 1)) {
                if (i + k > n) {
                    return -1; // If we can't flip the entire subarray of length k
                }
                flipIndices.add(i);
                flipCount++;
            }
        }

        return flipCount;
    }

    public static void main(String[] args) {
        MinimumKBitFlips solution = new MinimumKBitFlips();

        int[] nums1 = {0, 1, 0};
        int k1 = 1;
        System.out.println(solution.minKBitFlips(nums1, k1)); // Output: 2

        int[] nums2 = {1, 1, 0};
        int k2 = 2;
        System.out.println(solution.minKBitFlips(nums2, k2)); // Output: -1
    }
}
