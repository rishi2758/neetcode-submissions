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

    /*
     in order traverses in the root node in beteween , we fully procss the left child
      and we do some local computation and then go to its right node to process it.
      we don't need to result stack to hold the results for the children if we do then we need
      post order not in order
    */

    public int _kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int count = 0;
        while (current != null) {
            if (current.left == null) {
                // process current
                if (++count == k) return current.val;
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    //process current
                    if (++count == k) return current.val;
                    current = current.right;
                }
            }
        }
        return -1;
    }
    

    public int kthSmallest(TreeNode root, int k) {
        // Stack<Pair> stack = new Stack<>();
        // stack.push(new Pair(root, false));
        // int count = 0;
        // while (!stack.isEmpty()) {
        //     Pair process = stack.pop();
        //     TreeNode node = process.node;
        //     if (node == null) { continue; }
        //     if (process.ready) {
        //          ++count;
        //         if (count == k) {
        //             return node.val;
        //         }
        //     } else {
        //         stack.push(new Pair(node.right, false));
        //         stack.push(new Pair(node, true));
        //         stack.push(new Pair(node.left, false));
        //     }
        // }
        return _kthSmallest(root, k);
    }

    private void inOrder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        inOrder(root.left, inorder);
        inorder.add(root.val);
        inOrder(root.right, inorder);
    }
}
