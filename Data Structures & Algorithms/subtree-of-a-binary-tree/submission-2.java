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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(root.val == subRoot.val){
            boolean ans = rec(root, subRoot);
            if(ans) return true;
        } 
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean rec( TreeNode root, TreeNode sub){
        if(root == null && sub == null) return true;

        if(root == null || sub == null || root.val != sub.val ) return false;
        
        return rec(root.left, sub.left) && rec(root.right, sub.right);
    }
}

// TC O(m * n) as we check n subRoots node for matching m Nodes of root and rematch for left and right eventhough it was checked previously
// SC O(Max(m, n)) for rec call stack 