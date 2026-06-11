/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // if (node == null) return null;
        // Queue<Node> q = new LinkedList<>();
        // q.add(node);
        // Map<Integer, Node> clonedRef = new HashMap<>();
        // Node newNode = new Node(node.val);
        // clonedRef.put(newNode.val, newNode);
        
        // while(!q.isEmpty()) {
        //     Node orig = q.poll();
        //     List<Node> clonedChild = new ArrayList<>();
        //     for (Node cnode: orig.neighbors) {
        //         if (!clonedRef.containsKey(cnode.val)) {
        //             clonedRef.put(cnode.val, new Node(cnode.val));
        //             q.add(cnode);
        //         }
        //         clonedRef.get(orig.val).neighbors.add(clonedRef.get(cnode.val));
        //     }
        // }
        return _cloneGraph(node);
    }

    public Node _cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> clonedRef = new HashMap<>();
        Node newNode = new Node(node.val);
        clonedRef.put(newNode.val, newNode);

        dfs(node, clonedRef);

        return newNode;
    }

    private void dfs(Node node, Map<Integer, Node> clonedRef) {
        if (node == null) return;

        for (Node cnode: node.neighbors) {
            if (!clonedRef.containsKey(cnode.val)) {
                clonedRef.put(cnode.val, new Node(cnode.val));
                dfs(cnode, clonedRef);
            }
            clonedRef.get(node.val).neighbors.add(clonedRef.get(cnode.val));
        }
    }
 }