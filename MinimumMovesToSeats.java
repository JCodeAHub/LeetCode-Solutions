import java.util.Arrays;

public class MinimumMovesToSeats {
    public static int minMovesToSeat(int[] seats, int[] students) {
        // Sort both arrays
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        
        // Calculate the total moves needed by summing up the differences
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        
        return moves;
    }

    public static void main(String[] args) {
        // Example test case
        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};
        
        int result = minMovesToSeat(seats, students);
        System.out.println(result); // Output: 4
    }
}
