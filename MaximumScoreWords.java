// Question -> https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/

import java.util.HashMap;

public class MaximumScoreWords {

    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words, letters, score));  // Output: 23
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        return backtrack(words, letterCount, score, 0);
    }

    private static int backtrack(String[] words, int[] letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }

        // Skip the current word
        int skip = backtrack(words, letterCount, score, index + 1);

        // Choose the current word if possible
        int[] currentLetterCount = letterCount.clone();
        int wordScore = 0;
        boolean canForm = true;
        
        for (char c : words[index].toCharArray()) {
            if (currentLetterCount[c - 'a']-- > 0) {
                wordScore += score[c - 'a'];
            } else {
                canForm = false;
                break;
            }
        }

        int take = 0;
        if (canForm) {
            take = wordScore + backtrack(words, currentLetterCount, score, index + 1);
        }

        return Math.max(skip, take);
    }
}
