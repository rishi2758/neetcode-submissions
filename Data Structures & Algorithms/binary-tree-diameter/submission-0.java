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

    class Pair {
        TreeNode node;
        boolean ready;

        public Pair(TreeNode node, boolean ready) {
            this.node = node;
            this.ready = ready;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));

        Map<TreeNode, Integer> length = new HashMap<>();
        int diameter = 0;
        while (!stack.isEmpty()) {
            Pair process = stack.pop();
            if (process.node == null) continue;
            if (process.ready) {
                int leftLen = process.node.left == null ? 0 : length.get(process.node.left);
                int rightLen = process.node.right == null ? 0 : length.get(process.node.right);
                diameter = Math.max(diameter, leftLen + rightLen);
                length.put(process.node, Math.max(1+leftLen, 1+rightLen));
            } else {
                stack.push(new Pair(process.node, true));
                stack.push(new Pair(process.node.left, false));
                stack.push(new Pair(process.node.right, false));
            }
        }

        return diameter;
    }
}
