import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // Map to store the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean oddFound = false;
        
        // Iterate over the character counts
        for (int count : charCount.values()) {
            // Add the pairs to the length
            length += (count / 2) * 2;
            
            // Check if there is any odd count character
            if (count % 2 == 1) {
                oddFound = true;
            }
        }
        
        // If there was at least one odd count character, we can place one in the middle
        if (oddFound) {
            length += 1;
        }
        
        return length;
    }
    
    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        
        // Example test case
        String s = "abccccdd";
        int result = solution.longestPalindrome(s);
        System.out.println("The length of the longest palindrome that can be built is: " + result); // Output: 7
    }
}
