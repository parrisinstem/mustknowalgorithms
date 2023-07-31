package bfs;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Iterative bfsIterative = new Iterative();
        Recursive bfsRecursive = new Recursive();
        LevelOrder bfsLevelOrder = new LevelOrder();

        // Iterative BFS using Queue
        System.out.println("Iterative BFS:");
        bfsIterative.iterativeBFS(root);
        System.out.println();

        // Recursive BFS
        System.out.println("Recursive BFS:");
        bfsRecursive.recursiveBFS(root);
        System.out.println();

        // Level-Order Traversal using Queue
        System.out.println("Level-Order Traversal:");
        bfsLevelOrder.levelOrderTraversal(root);
        System.out.println();
    }
}
    
