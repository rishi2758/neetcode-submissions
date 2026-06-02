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

    int diameter = 0;

    private int height(TreeNode root) {
        if (root == null) return 0;
        
        int leftLen = height(root.left);
        int rightLen = height(root.right);
        diameter = Math.max(diameter, leftLen + rightLen);
        return Math.max(1+leftLen, 1+rightLen);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        Stack<Integer> results = new Stack<>();
        stack.push(new Pair(root, false));

        Map<TreeNode, Integer> length = new HashMap<>();
        int diameter = 0;
        while (!stack.isEmpty()) {
            Pair process = stack.pop();
            if (process.node == null) {results.push(0); continue;}
            if (process.ready) {
                int rightLen = results.pop();
                int leftLen = results.pop();
                diameter = Math.max(diameter, leftLen + rightLen);
                results.push(Math.max(1+leftLen, 1+rightLen));
            } else {
                stack.push(new Pair(process.node, true));
                stack.push(new Pair(process.node.left, false));
                stack.push(new Pair(process.node.right, false));
            }
        }
        // height(root);
        return diameter;
    }
}
