package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Recursive {
    // Helper method for recursive BFS
    private void recursiveBFSUtil(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }

        recursiveBFSUtil(queue.poll(), queue);
    }

    public void recursiveBFS(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        recursiveBFSUtil(queue.poll(), queue);
    }

    
}
