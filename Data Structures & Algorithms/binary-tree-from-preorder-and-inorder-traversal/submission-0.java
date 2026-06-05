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
    int preIndx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 0th index in range is always root
        // find leftRange = 0 , find(i) and rightRange = find(i)+1 to n
        // find(i)
        // 0 - find left and right count
        // 
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int i, int j) {
        if (i > j) return null;
        int rootVal = preorder[preIndx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = find(inorder, rootVal);
        root.left = buildTree(preorder, inorder, i , idx-1);
        root.right = buildTree(preorder, inorder, idx+1, j);
        return root;
    }

    private int find(int[] inorder, int value) {
        for (int i = 0 ; i < inorder.length; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}
