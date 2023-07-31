package dfs;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MaximumDepth{

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: If the node is null, the depth is 0.
        }

        int leftDepth = maxDepth(root.left); // Recursively calculate the depth of the left subtree.
        int rightDepth = maxDepth(root.right); // Recursively calculate the depth of the right subtree.

        return Math.max(leftDepth, rightDepth) + 1; // Return the maximum depth between left and right subtrees + 1 for the root node.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepth solver = new MaximumDepth();
        int maxDepth = solver.maxDepth(root);
        System.out.println("Maximum Depth of Binary Tree: " + maxDepth);
    }
}
