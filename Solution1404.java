public class Solution1404 {
    public int numSteps(String s) {
        int steps = 0; // Initialize step counter
        int carry = 0; // Carry for managing overflow in binary addition
        
        // Loop from the least significant bit to the most significant bit
        for (int i = s.length() - 1; i > 0; i--) {
            // Check the current bit considering the carry
            if (s.charAt(i) - '0' + carry == 1) {
                // If the bit plus carry equals 1, it's an odd number
                carry = 1; // When adding 1, the new carry is set
                steps += 2; // Adding 1 (making it even) and then dividing by 2
            } else {
                // If the bit plus carry equals 0 or 2, it's an even number
                steps += 1; // Just divide by 2
            }
        }
        
        // Account for the most significant bit which might have an extra carry
        return steps + carry;
    }

    public static void main(String[] args) {
        Solution1404 solution = new Solution1404();
        String binaryInput = "1101";
        int result = solution.numSteps(binaryInput);
        System.out.println("Number of steps to reduce " + binaryInput + " to 1: " + result);
    }
}
