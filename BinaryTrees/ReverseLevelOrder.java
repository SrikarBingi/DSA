package BinaryTrees;

import java.util.*;

public class ReverseLevelOrder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public static List<Integer> reverseLevelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            st.push(node.val);

            if (node.right != null) {
                q.offer(node.right);
            }
            if (node.left != null) {
                q.offer(node.left);
            }
        }
        while(!st.isEmpty()){
            res.add(st.peek());
            st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        // Create a sample binary tree:
        //      3
        //     / \
        //    9  20
        //       / \
        //      15  7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        
        List<Integer> result = reverseLevelOrder(root);

        System.out.println(result); // Output: [15, 7, 9, 20, 3]
    }
}
