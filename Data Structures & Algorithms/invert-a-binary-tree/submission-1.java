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
    public TreeNode invertTree(TreeNode root) {
        // if (root == null) return null;

        // TreeNode leftSubTree = invertTree(root.left);
        // TreeNode rightSubTree = invertTree(root.right);

        // root.right = leftSubTree;
        // root.left  = rightSubTree;

        return _invert(root);
    }

    class Pair {
        TreeNode node;
        boolean ready;

        public Pair(TreeNode node, boolean ready) {
            this.node = node;
            this.ready = ready;
        }
    }

    private TreeNode _invert(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));

        while(!stack.isEmpty()) {
            Pair process = stack.pop();
            if (process.node == null) continue;
            if (process.ready) {
                TreeNode tmp = process.node.left;
                process.node.left = process.node.right;
                process.node.right = tmp;
            } else {
                stack.push(new Pair(process.node, true));
                stack.push(new Pair(process.node.right, false));
                stack.push(new Pair(process.node.left, false));
            }
        }
        return root;
    }
}
