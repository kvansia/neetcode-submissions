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

    Map<Integer, Integer> inorderInd = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length ; i++){
            inorderInd.put(inorder[i], i);
        }

        return splitAndBuild(preorder, 0, preorder.length -1, 0, inorder.length - 1);    
    }

    private TreeNode splitAndBuild(int[] preorder, int prestart, int preend, int instart, int inend){

        if(prestart > preend || instart > inend) return null;

        int rootVal = preorder[prestart];
        int inroot = inorderInd.get(rootVal);

        int leftNodeCount = inroot - instart;

        TreeNode root = new TreeNode(rootVal);

        root.left = splitAndBuild(preorder, prestart + 1, prestart + leftNodeCount, instart, inroot - 1);
        root.right = splitAndBuild(preorder, prestart + 1 + leftNodeCount, preend, inroot + 1, inend);

        return root;
    }
}

// TC O(N) store every ele in the map
// SC O(N) map size  + Aux stack space from(O(logN) - O(N)) best - worst case
