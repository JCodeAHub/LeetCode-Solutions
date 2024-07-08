public class JosephusProblem {

    public static int findTheWinner(int n, int k) {
        // Create an array to keep track of the friends
        boolean[] friends = new boolean[n];
        
        // Initially, all friends are in the game
        for (int i = 0; i < n; i++) {
            friends[i] = true;
        }
        
        // Start the game with the first friend
        int currentIndex = 0;
        int remainingFriends = n;
        
        // Continue the game until only one friend remains
        while (remainingFriends > 1) {
            // Count k friends including the current one
            int count = 0;
            while (count < k) {
                if (friends[currentIndex]) {
                    count++;
                }
                if (count < k) {
                    currentIndex = (currentIndex + 1) % n;
                }
            }
            
            // The friend at currentIndex leaves the circle
            friends[currentIndex] = false;
            remainingFriends--;
            
            // Move to the next friend immediately clockwise
            currentIndex = (currentIndex + 1) % n;
            while (!friends[currentIndex]) {
                currentIndex = (currentIndex + 1) % n;
            }
        }
        
        // Find the remaining friend who is still in the game
        for (int i = 0; i < n; i++) {
            if (friends[i]) {
                return i + 1; // Return the 1-based index of the winner
            }
        }
        
        // If for some reason no friend is found (shouldn't happen), return -1
        return -1;
    }

    public static void main(String[] args) {
        int n = 5; // Number of friends
        int k = 2; // Counting step

        int winner = findTheWinner(n, k);
        System.out.println("The winner is friend number: " + winner);
    }
}
