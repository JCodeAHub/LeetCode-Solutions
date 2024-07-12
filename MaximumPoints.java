public class MaximumPoints {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(maxPoints(s, x, y));
    }

    // Function to calculate the maximum points by removing "ab" and "ba" substrings
    public static int maxPoints(String s, int x, int y) {
        // Determine the order of removal based on the points
        if (x > y) {
            // If x > y, prioritize removing "ab" first
            return removeAndCount(s, "ab", x, "ba", y);
        } else {
            // If y >= x, prioritize removing "ba" first
            return removeAndCount(s, "ba", y, "ab", x);
        }
    }

    // Helper function to remove substrings and calculate points
    private static int removeAndCount(String s, String first, int firstPoints, String second, int secondPoints) {
        // Initialize stack to help remove substrings
        StringBuilder sb = new StringBuilder();
        int points = 0;

        // Remove the higher-priority substring first
        for (char c : s.toCharArray()) {
            sb.append(c);
            // If the last two characters in sb match the first substring, remove them and add points
            if (sb.length() >= 2 && sb.substring(sb.length() - 2).equals(first)) {
                sb.delete(sb.length() - 2, sb.length());
                points += firstPoints;
            }
        }

        // Now remove the lower-priority substring
        s = sb.toString();
        sb.setLength(0); // Clear the StringBuilder for reuse

        for (char c : s.toCharArray()) {
            sb.append(c);
            // If the last two characters in sb match the second substring, remove them and add points
            if (sb.length() >= 2 && sb.substring(sb.length() - 2).equals(second)) {
                sb.delete(sb.length() - 2, sb.length());
                points += secondPoints;
            }
        }

        return points;
    }
}
