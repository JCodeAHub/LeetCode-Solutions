import java.util.*;

public class CommonCharacters {
    public static List<String> commonChars(String[] words) {
        // Array to store the minimum frequency of each character across all words
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        // Iterate through each word in the array
        for (String word : words) {
            // Array to store the frequency of each character in the current word
            int[] charFreq = new int[26];
            for (char c : word.toCharArray()) {
                charFreq[c - 'a']++;
            }
            // Update the minimum frequency array
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }
        
        // List to store the common characters
        List<String> result = new ArrayList<>();
        // Add characters to the result list based on their minimum frequency
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char)(i + 'a')));
                minFreq[i]--;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        System.out.println(commonChars(words));
    }
}
