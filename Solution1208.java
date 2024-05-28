public class Solution1208 {
    // Function to find the maximum length of a substring that can be changed with the given cost
    public int equalSubstring(String s, String t, int maxCost) {
        // Length of the input strings
        int n = s.length();

        // Two pointers for the sliding window
        int left = 0, right = 0;

        // Variable to store the current total cost of the substring
        int currentCost = 0;

        // Variable to store the maximum length of the substring
        int maxLength = 0;

        // Iterate through the string using the right pointer
        while (right < n) {
            // Calculate the cost of changing s[right] to t[right]
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            // If the current total cost exceeds maxCost, move the left pointer
            while (currentCost > maxCost) {
                // Subtract the cost of changing s[left] to t[left] as the window shrinks
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                // Move the left pointer to the right
                left++;
            }

            // Calculate the current length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);

            // Move the right pointer to the right
            right++;
        }

        // Return the maximum length of the valid substring
        return maxLength;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution1208 solution = new Solution1208();

        // Test case 1
        String s1 = "abcd";
        String t1 = "bcdf";
        int maxCost1 = 3;
        System.out.println("Test Case 1: " + solution.equalSubstring(s1, t1, maxCost1)); // Expected output: 3

        // Test case 2
        String s2 = "abcd";
        String t2 = "cdef";
        int maxCost2 = 3;
        System.out.println("Test Case 2: " + solution.equalSubstring(s2, t2, maxCost2)); // Expected output: 1

        // Test case 3
        String s3 = "abcd";
        String t3 = "acde";
        int maxCost3 = 0;
        System.out.println("Test Case 3: " + solution.equalSubstring(s3, t3, maxCost3)); // Expected output: 1
    }
}
