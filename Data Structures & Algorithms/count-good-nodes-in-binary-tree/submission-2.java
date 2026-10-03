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
    public int goodNodes(TreeNode root) {
        //  consider it is not a BST
        // we will maintain a max val on the given path and check if the cur node is greater than it will be considered as a good node and update the max val
        
        if(root == null) return 0;

        int[] ans = new int[1];
        rec(root, ans, root.val);
        return ans[0];
    }

    private void rec(TreeNode node, int[] ans, int max){
        if(node == null) return;
        
        if(node.val >= max){
            max = node.val;
            ans[0] += 1;
        }

        rec(node.left, ans, max);
        rec(node.right, ans, max);
    }
}

// TC O(N) iterate through every node
// SC O(N) Aux stack space
 