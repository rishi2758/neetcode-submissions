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

    boolean balanced = true;

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH-rightH) > 1) {
            balanced=false;
        }
        return 1 + Math.max(leftH, rightH);
    }

    public boolean isBalanced(TreeNode root) {

        // Stack<Pair> stack = new Stack<>();
        // stack.push(new Pair(root, false));
        // Stack<Integer> height = new Stack<>();

        // while(!stack.isEmpty()) {
        //     Pair process = stack.pop();
        //     TreeNode node = process.node;
        //     if (node == null) {
        //         height.push(0);
        //         continue;
        //     }
        //     if (process.ready) {
        //         int rightLen = height.pop();
        //         int leftLen  = height.pop();
        //         if (Math.abs(rightLen-leftLen) > 1) {
        //             return false;
        //         }
        //         height.push(Math.max(rightLen, leftLen)+1);
        //     } else {
        //         stack.push(new Pair(node, true));
        //         stack.push(new Pair(node.left, false));
        //         stack.push(new Pair(node.right, false));
        //     }
        // }
        height(root);
        return balanced;
    }
}
