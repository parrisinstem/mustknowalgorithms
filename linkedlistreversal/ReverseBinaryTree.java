package linkedlistreversal;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ReverseBinaryTree {
    public TreeNode reverseBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively reverse the left and right subtrees
        reverseBinaryTree(root.left);
        reverseBinaryTree(root.right);

        return root;
    }

    // Helper method to print the binary tree using inorder traversal
    public void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ReverseBinaryTree solution = new ReverseBinaryTree();

        System.out.println("Original Binary Tree (Inorder Traversal):");
        solution.printInorder(root);
        System.out.println();

        TreeNode reversedRoot = solution.reverseBinaryTree(root);

        System.out.println("Reversed Binary Tree (Inorder Traversal):");
        solution.printInorder(reversedRoot);
    }
}
