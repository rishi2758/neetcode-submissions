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

    /*
            3
          4    5
        1     2
    */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) return false;

        if (root.val == subRoot.val) {
            if(isSameTree(root, subRoot)) return true;
        }
        return isSubtree(root.left, subRoot) 
            || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode subTreeRef, TreeNode subRoot) {
        if ((subTreeRef == null && subRoot != null) 
            || (subTreeRef != null && subRoot == null)) return false;
        if (subTreeRef == null && subRoot == null) return true;

        if (subTreeRef.val == subRoot.val) {
            return isSameTree(subTreeRef.left, subRoot.left) 
            && isSameTree(subTreeRef.right, subRoot.right);
        } else {
            return false;
        }
    }
}
