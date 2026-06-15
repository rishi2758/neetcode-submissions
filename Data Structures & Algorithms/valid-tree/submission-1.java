class Solution {
    // 0 -> 1 -> 2 -> 3
    //        -> 3
    //        -> 4
    
    public boolean validTree(int n, int[][] edges) {
        List[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int[] visited = new int[n];
        int count = 0;
        boolean hasCycle = dfs(-1, 0, adjList, visited);
        if (hasCycle) return false;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) return false;
        }
        return true;
    }

    private boolean dfs(int parent, int node, List<Integer>[] adjList, int[] visited) {
        if (visited[node] == 2) return false;
        if (visited[node] == 1) return true;

        visited[node] = 1;
        for (int adj: adjList[node]) {
            if (adj == parent) continue;
            if (dfs(node, adj, adjList, visited)) return true;
        }
        visited[node] = 2;
        return false;
    }


}
