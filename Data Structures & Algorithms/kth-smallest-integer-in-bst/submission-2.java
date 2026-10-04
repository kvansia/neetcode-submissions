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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        // stack.addFirst(root);
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.addFirst(cur);
                cur = cur.left;
            }

            cur = stack.poll();
            k--;

            if(k == 0){
                return cur.val;
            }

            cur = cur.right;            
        }

        return -1;
    }
}

// TC O(h+k) h : height of the tree;
// SC O(h) len of stack to be stored in the stack
