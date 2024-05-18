LeetCode -> https://leetcode.com/problems/distribute-coins-in-binary-tree/description/?envType=daily-question&envId=2024-05-18

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution979 {
    private int moves = 0;  // Variable to keep track of the total number of moves

    // Main method to be called to distribute coins in the tree
    public int distributeCoins(TreeNode root) {
        dfs(root);  // Start the DFS from the root node
        return moves;  // Return the total number of moves required
    }

    // Helper method to perform DFS and calculate coin balance
    private int dfs(TreeNode node) {
        if (node == null) return 0;  // Base case: if the node is null, it has no balance to return
        
        // Recursively process the left subtree and get its coin balance
        int leftBalance = dfs(node.left);
        
        // Recursively process the right subtree and get its coin balance
        int rightBalance = dfs(node.right);
        
        // Calculate the balance for the current node
        // Balance is calculated as: coins at this node - 1 (coin needed for this node)
        // plus the balance from the left subtree and the right subtree
        int balance = node.val - 1 + leftBalance + rightBalance;
        
        // The number of moves needed for this node to balance itself and its subtrees
        // is the absolute value of its balance
        moves += Math.abs(balance);
        
        // Return the balance to the parent node so it can use this balance in its calculation
        return balance;
    }
    
    // Main method for testing the solution
    public static void main(String[] args) {
        // Example tree:
        //       3
        //      / \
        //     0   0
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        
        Solution979 solution = new Solution979();
        int result = solution.distributeCoins(root);
        
        System.out.println("Minimum number of moves required: " + result);  // Output: 2
    }
}
