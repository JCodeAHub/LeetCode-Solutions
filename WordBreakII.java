import java.util.*;

public class WordBreakII {
    
    // Method to return all possible sentences from s using words in wordDict
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Use a HashSet for quick look-up of dictionary words
        Set<String> wordSet = new HashSet<>(wordDict);
        // Memoization map to store the results of subproblems
        Map<String, List<String>> memo = new HashMap<>();
        // Start the recursive backtracking function
        return backtrack(s, wordSet, memo);
    }
    
    // Helper method for backtracking
    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        // If the current substring has already been processed, return the stored result
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        // If the entire string is a word, add it to the result
        if (wordSet.contains(s)) {
            result.add(s);
        }
        
        // Try every possible prefix of the string
        for (int i = 1; i < s.length(); i++) {
            // Divide the string into prefix and suffix
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            
            // If the prefix is a valid word, process the suffix recursively
            if (wordSet.contains(prefix)) {
                List<String> suffixSentences = backtrack(suffix, wordSet, memo);
                for (String sentence : suffixSentences) {
                    // Construct the sentence and add it to the result
                    result.add(prefix + " " + sentence);
                }
            }
        }
        
        // Store the result in memoization map before returning
        memo.put(s, result);
        return result;
    }
    
    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        
        // Get the list of possible sentences
        List<String> sentences = solution.wordBreak(s, wordDict);
        
        // Print each possible sentence
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
