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
    public int kthSmallest(TreeNode root, int k) {
        // List<Integer> inorder = new ArrayList<>();
        // inOrder(root, inorder);
        // return inorder.get(k-1);

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));
        int count = 0;
        while (!stack.isEmpty()) {
            Pair process = stack.pop();
            TreeNode node = process.node;
            if (node == null) { continue; }
            if (process.ready) {
                 ++count;
                if (count == k) {
                    return node.val;
                }
            } else {
                stack.push(new Pair(node.right, false));
                stack.push(new Pair(node, true));
                stack.push(new Pair(node.left, false));
            }
        }
        return -1;
    }

    private void inOrder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        inOrder(root.left, inorder);
        inorder.add(root.val);
        inOrder(root.right, inorder);
    }
}
