import java.util.Stack;

public class ReverseSubstrings {

    public static String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        // Iterate over each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Push the current string to the stack and start a new one
                stack.push(current);
                current = new StringBuilder();
            } else if (ch == ')') {
                // Reverse the current string
                current.reverse();
                // Append it to the string at the top of the stack
                current = stack.pop().append(current);
            } else {
                // Append the character to the current string
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String input = "(abcd)";
        String output = reverseParentheses(input);
        System.out.println(output);  // Output: "dcba"
    }
}
