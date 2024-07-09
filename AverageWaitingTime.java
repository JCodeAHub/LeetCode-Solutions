public class AverageWaitingTime {
    public static void main(String[] args) {
        // Example input for testing
        int[][] customers = {
            {1, 2}, {2, 5}, {4, 3}, {5, 4}, {10, 1}, {12, 5}, {14, 6}, {16, 8}, {20, 3}, {25, 10}
        };

        System.out.printf("%.5f", averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;  // Use long to prevent overflow for large inputs
        int currentTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookingTime = customer[1];

            // Update current time to when the chef can start the next order
            currentTime = Math.max(currentTime, arrivalTime);
            currentTime += cookingTime;

            // Calculate the waiting time for the current customer
            totalWaitingTime += currentTime - arrivalTime;
        }

        // Calculate the average waiting time
        double averageWaitingTime = (double) totalWaitingTime / customers.length;
        return averageWaitingTime;
    }
}
