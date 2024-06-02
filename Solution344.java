public class Solution344 {
    public void reverseString(char[] s) {
        // Initialize two pointers, one at the beginning and one at the end of the array
        int left = 0;
        int right = s.length - 1;

        // Continue swapping the characters until the two pointers meet in the middle
        while (left < right) {
            // Swap the characters at the left and right pointers
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move the pointers towards the center
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Solution344 sol = new Solution344();
        
        // Example 1
        char[] example1 = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(example1);
        // Output should be ['o', 'l', 'l', 'e', 'h']
        System.out.println(example1);

        // Example 2
        char[] example2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        sol.reverseString(example2);
        // Output should be ['h', 'a', 'n', 'n', 'a', 'H']
        System.out.println(example2);
    }
}
