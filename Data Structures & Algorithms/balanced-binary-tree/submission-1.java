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
    public boolean isBalanced(TreeNode root) {
        return rec(root) != -1;
    }

    private int rec(TreeNode node){
        if(node == null) return 0;

        int l = rec(node.left);
        if(l == -1) return -1;

        int r = rec(node.right);
        if(r == -1) return -1;

        if(Math.abs(r- l) > 1) return -1;

        return Math.max(l, r) + 1;
    }
}

// TC O(n) vis n num of node 
// SC O(n) rec stack space