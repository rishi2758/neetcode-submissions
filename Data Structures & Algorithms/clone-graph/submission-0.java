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
        // Map<Integer, List<Integer>> adjList = new HashMap<>();
        // constructAdjList(node, adjList, new HashSet<>());
        // return dfs(1, adjList, new HashSet<>());
        if (node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Node newNode = new Node(node.val, new ArrayList<>(node.neighbors));
        q.add(newNode);
        Map<Integer, Node> visited = new HashMap<>();
        visited.put(newNode.val, newNode);
        
        while(!q.isEmpty()) {
            Node clone = q.poll();
            List<Node> clonedChild = new ArrayList<>();
            for (Node cnode: clone.neighbors) {
                Node childClone = visited.getOrDefault(cnode.val, new Node(cnode.val, new ArrayList<>(cnode.neighbors)));
                clonedChild.add(childClone);
                if(!visited.containsKey(cnode.val)) {
                    visited.put(cnode.val, childClone);
                    q.add(childClone);
                }
            }
            clone.neighbors = clonedChild;
        }
        return newNode;
    }

    private Node dfs(int index, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (index == adjList.size() || visited.contains(index)) return null;
        visited.add(index);
        Node node = new Node(index, new ArrayList<>());
        List<Node> child = new ArrayList<>();
        for (int c : adjList.get(index)) {
            node.neighbors.add(dfs(c, adjList, visited));
        }
        return node;
    }

    private void constructAdjList(Node node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        
        if (node != null && !visited.contains(node.val)) {
            visited.add(node.val);
            for(Node child : node.neighbors) {
                adjList.computeIfAbsent(node.val, k -> new ArrayList<>())
                    .add(child.val);
                constructAdjList(child, adjList, visited);
            }
        }
    }
}