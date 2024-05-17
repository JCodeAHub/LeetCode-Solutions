// LeetCode -> https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution1325 {
    // Method to remove leaf nodes with a specific target value
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // If the current node is null, return null
        if (root == null) return null;
        
        // Recursively call the method on the left child
        root.left = removeLeafNodes(root.left, target);
        // Recursively call the method on the right child
        root.right = removeLeafNodes(root.right, target);
        
        // Check if the current node is a leaf (no left and right children)
        // and its value matches the target
        if (root.left == null && root.right == null && root.val == target) {
            // If both conditions are true, return null to remove the leaf node
            return null;
        }
        
        // If the current node is not a target leaf node, return the current node
        return root;
    }

     // Method to print the binary tree (for testing)
     private static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        Solution1325 solution = new Solution1325();
        
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        
        // Print original tree
        System.out.print("\nOriginal Tree: ");
        printTree(root);
        
        // Remove leaf nodes with value 2
        int target = 2;
        TreeNode newRoot = solution.removeLeafNodes(root, target);
        
        // Print modified tree
        System.out.print("\nModified Tree after removing leaf nodes with value " + target + " : ");
        printTree(newRoot);
        System.out.println();
    }
}

