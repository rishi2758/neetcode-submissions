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

        3
     3
   4   2
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return good(root, Integer.MIN_VALUE);
    }

    public int good(TreeNode node, int maxSeenSoFar) {
        if (node == null) return 0;

        if (maxSeenSoFar <= node.val) {
            return 1 + good(node.left, node.val) + good(node.right, node.val);
        } else {
            return good(node.left, maxSeenSoFar) + good(node.right, maxSeenSoFar);
        }
    }
}
