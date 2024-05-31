public class Solution260 {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all the elements to get the XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find a set bit in the result (xor)
        // This bit will be different between the two unique numbers
        int diffBit = xor & (-xor);

        // Step 3: Divide the numbers into two groups and XOR each group separately
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                // Group 1: Numbers with the bit unset
                result[0] ^= num;
            } else {
                // Group 2: Numbers with the bit set
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution260 solution = new Solution260();
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        int[] result = solution.singleNumber(nums);
        System.out.println(result[0] + " " + result[1]); // Output could be [3, 5] or [5, 3]
    }
}
