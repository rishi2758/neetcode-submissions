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

        5
    1       4
        3       6
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
    public boolean isValidBST(TreeNode root) {
       // all left keys are lesser than its parent, 
       // all right keys are greater than its parent
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, false));
        Stack<int[]> minmax = new Stack<>();

        while (!stack.isEmpty()) {
            Pair process = stack.pop();
            TreeNode node = process.node;
            if (node == null) { minmax.push(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE}); continue; }
            if (process.ready) {
                int[] leftMinMax = minmax.pop();
                int[] rightMinMax = minmax.pop();
                
                if (node.val < rightMinMax[0] && node.val > leftMinMax[1]) {
                    minmax.push(new int[] {
                        Math.min(node.val, Math.min(leftMinMax[0], rightMinMax[0])),
                        Math.max(node.val, Math.max(leftMinMax[1], rightMinMax[1]))
                    });
                } else {
                    return false;
                }
            } else {
                stack.push(new Pair(node, true));
                stack.push(new Pair(node.left, false));
                stack.push(new Pair(node.right, false));
            }
        }

        return true;
    }

}
