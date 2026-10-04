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
        // Inorder traversal : It stores nodes in ascending order in BST
        List<Integer> lst = new ArrayList<>();
        rec(root, lst);

        for(int i = 0; i < lst.size(); i++){
            if(i + 1 == k) return lst.get(i);
        }
        return -1;
    }

    private void rec(TreeNode root, List<Integer> lst){
        if(root == null) return;
        
        rec(root.left, lst);

        lst.add(root.val);

        rec(root.right, lst);
    }
}
