import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array and sort it to get the expected order
        int[] expected = heights.clone();
        Arrays.sort(expected);
        
        // Initialize a counter to count the number of indices where heights and expected differ
        int count = 0;
        
        // Compare the heights array with the expected array
        for (int i = 0; i < heights.length; i++) {
            // If the height at index i does not match the expected height, increment the counter
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        // Return the count of indices where heights and expected differ
        return count;
    }

    public static void main(String[] args) {
        // Example usage
        HeightChecker checker = new HeightChecker();
        int[] heights = {1, 1, 4, 2, 1, 3};
        int result = checker.heightChecker(heights);
        
        // Output should be 3, as indices 2, 4, and 5 do not match
        System.out.println(result); // 3
    }
}
