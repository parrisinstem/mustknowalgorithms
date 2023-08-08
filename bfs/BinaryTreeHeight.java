package bfs;

import java.util.LinkedList;
import java.util.Queue;

// Define a TreeNode class for the binary tree node structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to create a TreeNode with a given value
    TreeNode(int val) {
        this.val = val;
    }
}

// Class to find the height of a binary tree using BFS approach
public class BinaryTreeHeight {

    // BFS approach to find the height of a binary tree
    public static int bfsHeight(TreeNode root) {
        // If the root is null, the height of the tree is 0
        if (root == null) {
            return 0;
        }

        // Create a queue to perform BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root node to the queue
        queue.offer(root);

        // Initialize the height to 0
        int height = 0;

        // Perform BFS traversal until the queue is empty
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int levelSize = queue.size();

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                // Remove the first node from the queue
                TreeNode node = queue.poll();

                // Add the left and right child nodes to the queue if they exist
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Increment the height for each level
            height++;
        }

        // Return the calculated height of the binary tree
        return height;
    }

    // Main method to test the 'bfsHeight' function
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Calculate the height of the binary tree using BFS
        int bfsHeight = bfsHeight(root);

        // Print the calculated height of the binary tree
        System.out.println("Height of the binary tree using BFS: " + bfsHeight);
    }
}
