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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sameLevelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                sameLevelNodes.add(tmp.val);
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
            result.add(sameLevelNodes);
        }
        return result;
    }
}
