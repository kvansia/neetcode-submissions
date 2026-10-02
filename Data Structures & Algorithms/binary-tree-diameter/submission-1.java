/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDia = new int[1];
        int dia = rec(root, maxDia);
        return maxDia[0];
    }

    private int rec(TreeNode node, int[] maxDia){
        if(node == null) return 0;

        int l = rec(node.left, maxDia);
        int r = rec(node.right, maxDia);
        
        maxDia[0] = Math.max(maxDia[0], l + r);
        return Math.max(l, r) + 1;
    }
}

// TC: O(n)
// SC: O(n)
