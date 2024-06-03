public class Solution2486 {
    public int appendCharacters(String s, String t) {
        // Pointer for the string t
        int tIndex = 0;
        // Length of the string t
        int tLength = t.length();
        
        // Iterate through each character in string s
        for (int i = 0; i < s.length(); i++) {
            // If the current character in s matches the current character in t
            if (s.charAt(i) == t.charAt(tIndex)) {
                // Move to the next character in t
                tIndex++;
                // If we have matched all characters in t
                if (tIndex == tLength) {
                    // No need to append any characters
                    return 0;
                }
            }
        }
        
        // Return the number of characters in t that weren't matched with s
        return tLength - tIndex;
    }

    public static void main(String[] args) {
        Solution2486 sol = new Solution2486();
        
        // Test case
        String s = "coaching";
        String t = "coding";
        
        // Expected output: 4
        System.out.println(sol.appendCharacters(s, t));
    }
}
