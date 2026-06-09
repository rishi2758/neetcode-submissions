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

    public int maxPathSum(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        stack.push(new Pair(root, false));
        Stack<Integer> result = new Stack<>();
        while (!stack.isEmpty()) {
            Pair process = stack.pop();
            TreeNode node = process.node;
            if (node == null) {result.add(0); continue;}
            if (process.ready) {
                int leftMax = Math.max(0, result.pop());
                int rightMax = Math.max(0, result.pop());
                int throughNode = node.val + leftMax + rightMax;
                max = Math.max(max, throughNode);

                result.push(node.val + Math.max(0, Math.max(leftMax, rightMax)));
            } else {
                stack.push(new Pair(node, true));
                stack.push(new Pair(node.left, false));
                stack.push(new Pair(node.right, false));
            }
        }
        return max;
    }
}
