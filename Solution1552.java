public class Solution1552 {
    public int maxDistance(int[] position, int m) {
        // Sort the positions of the baskets
        Arrays.sort(position);
        
        // Helper function to check if a given minimum distance can be achieved
        boolean canPlaceBalls(int[] position, int m, int minDist) {
            int count = 1; // Place the first ball in the first basket
            int lastPosition = position[0];
            
            for (int i = 1; i < position.length; i++) {
                // If the current position is at least minDist away from the last position
                if (position[i] - lastPosition >= minDist) {
                    count++; // Place another ball here
                    lastPosition = position[i]; // Update the last position
                }
                if (count == m) {
                    return true; // Successfully placed all m balls
                }
            }
            return false; // Could not place all m balls with at least minDist apart
        }

        int left = 1; // Minimum possible distance
        int right = position[position.length - 1] - position[0]; // Maximum possible distance
        int answer = 0;
        
        // Binary search to find the maximum minimum distance
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(position, m, mid)) {
                answer = mid; // Update answer to the current mid
                left = mid + 1; // Try for a larger distance
            } else {
                right = mid - 1; // Try for a smaller distance
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution1552 sol = new Solution1552();
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(sol.maxDistance(position, m)); // Output: 3
    }
}
