import java.util.*;

public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Count the frequency of each element in arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create an array to store the result
        int[] result = new int[arr1.length];
        int index = 0;

        // Step 3: Place elements in the order specified by arr2
        for (int num : arr2) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                for (int i = 0; i < count; i++) {
                    result[index++] = num;
                }
                countMap.remove(num); // Remove the element from countMap after placing
            }
        }

        // Step 4: Sort the remaining elements not in arr2
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);

        // Step 5: Append the sorted remaining elements to the result array
        for (int num : remaining) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1122 sol = new Solution1122();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] sortedArr = sol.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(sortedArr)); // Print the sorted array
    }
}
