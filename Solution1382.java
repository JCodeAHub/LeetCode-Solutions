public class Solution1382 {
    // Method to perform in-order traversal and store nodes in a list
    private void inorderTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root);
        inorderTraversal(root.right, nodes);
    }

    // Method to build a balanced BST from a sorted list of nodes
    private TreeNode buildBalancedBST(List<TreeNode> nodes, int start, int end) {
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);

        // Recursively build left and right subtrees
        node.left = buildBalancedBST(nodes, start, mid - 1);
        node.right = buildBalancedBST(nodes, mid + 1, end);

        return node;
    }

    // Main method to balance the BST
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);  // Step 1: Get the sorted list of nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);  // Step 2: Build the balanced BST
    }

    // Helper method to print the tree (for debugging purposes)
    public void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        SolutionSolution1382 sol = new SolutionSolution1382();

        // Construct the input tree: [1,null,2,null,3,null,4,null,null]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Balance the BST
        TreeNode balancedRoot = sol.balanceBST(root);

        // Print the balanced tree
        sol.printTree(balancedRoot);  // Example output: 2 1 3 4
    }
}
