import java.util.Arrays;

public class MinDifferenceAfterThreeMoves {
    public static int minDifference(int[] nums) {
        // If the array length is less than or equal to 4, we can make all elements the same in at most 3 moves.
        if (nums.length <= 4) return 0;
        
        // Sort the array to easily find the smallest and largest elements after at most 3 moves.
        Arrays.sort(nums);
        
        // Possible scenarios after 3 moves:
        // 1. Change the three largest elements to the value of the 4th largest element.
        int option1 = nums[nums.length - 4] - nums[0];
        // 2. Change the two largest elements to the value of the 3rd largest element and the smallest element to the value of the 4th smallest element.
        int option2 = nums[nums.length - 3] - nums[1];
        // 3. Change the largest element to the value of the 2nd largest element and the two smallest elements to the value of the 3rd smallest element.
        int option3 = nums[nums.length - 2] - nums[2];
        // 4. Change the three smallest elements to the value of the 4th smallest element.
        int option4 = nums[nums.length - 1] - nums[3];
        
        // The minimum difference after at most 3 moves will be the smallest of these options.
        return Math.min(Math.min(option1, option2), Math.min(option3, option4));
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 3, 2, 4};
        System.out.println(minDifference(nums1)); // Output: 0

        int[] nums2 = {1, 5, 0, 10, 14};
        System.out.println(minDifference(nums2)); // Output: 1

        int[] nums3 = {6, 6, 0, 1, 1, 4, 6};
        System.out.println(minDifference(nums3)); // Output: 2
    }
}
