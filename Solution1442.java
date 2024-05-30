import java.util.HashMap;
import java.util.Map;

public class Solution1442 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        // Create a prefix XOR array to store the XOR of elements from the start to the current index.
        int[] prefixXor = new int[n + 1];  // Initialize with size n+1 to handle prefix XORs easily

        // Compute prefix XOR array where prefixXor[i] is the XOR of all elements from arr[0] to arr[i-1].
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        // HashMap to count the occurrences of each prefix XOR value.
        Map<Integer, Integer> countMap = new HashMap<>();
        // HashMap to sum the indices of each prefix XOR value.
        Map<Integer, Integer> indexSumMap = new HashMap<>();
        // Variable to store the total number of valid triplets.
        int tripletsCount = 0;

        // Iterate through the array to find the triplets.
        for (int k = 0; k < n; k++) {
            int xorKPlus1 = prefixXor[k + 1]; // Current prefix XOR up to index k+1

            // Check if this prefix XOR value has been seen before.
            if (countMap.containsKey(xorKPlus1)) {
                // If yes, calculate the number of valid triplets.
                // The number of valid triplets is determined by the formula:
                // (count of this prefix XOR value) * k - (sum of indices where this prefix XOR value appeared)
                tripletsCount += countMap.get(xorKPlus1) * k - indexSumMap.get(xorKPlus1);
            }

            // Update the maps with the current prefix XOR value.
            // Increment the count of the current prefix XOR value.
            countMap.put(prefixXor[k], countMap.getOrDefault(prefixXor[k], 0) + 1);
            // Add the current index k to the sum of indices for the current prefix XOR value.
            indexSumMap.put(prefixXor[k], indexSumMap.getOrDefault(prefixXor[k], 0) + k);
        }

        // Return the total number of valid triplets found.
        return tripletsCount;
    }

    public static void main(String[] args) {
        Solution1442 sol = new Solution1442();
        int[] arr = {2, 3, 1, 6, 7};
        System.out.println(sol.countTriplets(arr));  // Output: 4
    }
}
