package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// Definition for a binary tree node.
class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int x) { val = x; }
}
public class LevelOrder {
    public static ArrayList<Integer> levelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> q = new LinkedList<>();  // Initialize a queue for BFS
        ArrayList<Integer> res = new ArrayList<>();  // Initialize the result list

        // If the tree is empty, return an empty list
        if (root == null) {
            return res;
        }

        q.add(root);  // Start with the root node

        while (!q.isEmpty()) {
            int size = q.size();  // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = q.poll();  // Remove the node from the queue
                
                // Add left and right children to the queue if they exist
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

                // Add the current node's value to the result list
                res.add(node.val);
            }
        }

        return res;  // Return the result list containing level-order traversal
    }

    // Test case
    public static void main(String[] args) {
        // Create a sample binary tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);

        
        ArrayList<Integer> result = levelOrder(root);

        // Print the result list
        System.out.println(result);  // Expected output: [1, 2, 3, 4, 5]
    }
}
