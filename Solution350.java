import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create a HashMap to store the count of each number in nums1
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Populate the HashMap with counts of each number in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Create a List to store the intersection result
        List<Integer> result = new ArrayList<>();
        
        // Iterate through nums2 and find common elements
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num); // Add the common element to the result
                map.put(num, map.get(num) - 1); // Decrease the count in the HashMap
            }
        }
        
        // Convert the result List to an array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        
        // Return the intersection array
        return intersection;
    }
    
    public static void main(String[] args) {
        Solution350 solution = new Solution350();
        
        // Example 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solution.intersect(nums1, nums2);
        
        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 2 2
    }
}
