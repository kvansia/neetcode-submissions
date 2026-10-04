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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        rec(root, maxSum);

        return maxSum[0];
    }

    private int rec(TreeNode node, int[] maxSum){
        if(node == null) return 0;

        int l = rec(node.left, maxSum);
        int r = rec(node.right, maxSum);
        if(l < 0) l = 0;
        if(r < 0) r = 0;
        
        maxSum[0] = Math.max(maxSum[0], l + node.val + r);

        return node.val + Math.max(l, r);
    }
}

// TC O(N) N: number of nodes in the tree
// SC O(H) H: height of binary tree