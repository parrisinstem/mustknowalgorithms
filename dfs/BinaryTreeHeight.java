// Package declaration for the 'dfs' package

// Import necessary Java utility classes
import java.util.LinkedList;
import java.util.Queue;

// TreeNode class representing nodes of a binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize a TreeNode with a given value
    TreeNode(int val) {
        this.val = val;
    }
}

// Class to find the height of a binary tree using DFS approach
public class BinaryTreeHeight {

    // Method to find the height of the binary tree using Depth-First Search (DFS)
    public static int dfsHeight(TreeNode root) {
        // Base case: If the root is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively find the height of the left and right subtrees
        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);

        // The height of the binary tree is the maximum of the left and right subtree heights plus 1 (for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Find the height of the binary tree using DFS and store it in 'dfsHeight'
        int dfsHeight = dfsHeight(root);

        // Print the height of the binary tree obtained from DFS
        System.out.println("Height of the binary tree using DFS: " + dfsHeight);
    }
}
