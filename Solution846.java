import java.util.Map;
import java.util.TreeMap;

public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Check if the hand can be evenly divided into groups of groupSize
        if (hand.length % groupSize != 0) return false;

        // Use a TreeMap to store the counts of each card
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Iterate through the map to form groups
        while (!countMap.isEmpty()) {
            int firstCard = countMap.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!countMap.containsKey(currentCard)) return false;
                int count = countMap.get(currentCard);
                if (count == 1) {
                    countMap.remove(currentCard);
                } else {
                    countMap.put(currentCard, count - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution846 solution = new Solution846();
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(solution.isNStraightHand(hand, groupSize));  // Output: true
    }
}
