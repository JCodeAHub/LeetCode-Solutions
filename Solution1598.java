public class Solution1598 {
    public int minOperations(String[] logs) {
        // Initialize a counter to track the depth of the current folder
        int depth = 0;

        // Iterate through each operation in the logs
        for (String log : logs) {
            // If the operation is "../", move to the parent folder
            if (log.equals("../")) {
                // Ensure depth does not go below 0 (main folder)
                if (depth > 0) {
                    depth--;
                }
            } 
            // If the operation is "./", stay in the current folder
            else if (log.equals("./")) {
                // No change in depth, so do nothing
                continue;
            } 
            // For "x/", move to the child folder named x
            else {
                // Increase the depth as we move to a child folder
                depth++;
            }
        }

        // The depth value now represents the minimum number of operations needed to return to the main folder
        return depth;
    }

    public static void main(String[] args) {
        Solution1598 sol = new Solution1598();
        String[] logs1 = {"d1/","d2/","../","d21/","./"};
        System.out.println(sol.minOperations(logs1));  // Output: 2
        
        String[] logs2 = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println(sol.minOperations(logs2));  // Output: 3
        
        String[] logs3 = {"d1/","../","../","../"};
        System.out.println(sol.minOperations(logs3));  // Output: 0
    }
}
