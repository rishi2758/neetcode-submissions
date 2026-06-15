class Solution {

    int[] uf;
    int[] size;
    int component;

    public void init(int n) {
        this.uf = new int[n];
        this.size = new int[n];
        this.component = n;

        for (int i = 0; i < n; i++) {
            uf[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA == rootB) return false;

        --component;
        if (size[rootA] < size[rootB]) {
            uf[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            uf[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    }

    private int root(int a) {
        while(a != uf[a]) {
            int parent = uf[a];
            uf[a] = uf[uf[parent]];
            a = parent;
        }
        return a;
    }

    private boolean _valid(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        init(n);
        for (int[] edge: edges) {
            if(!union(edge[0], edge[1])) return false;
        }
        return component == 1;
    }
    
    public boolean validTree(int n, int[][] edges) {
        // if (edges.length != n-1) return false;
        // List[] adjList = new List[n];
        // for (int i = 0; i < n; i++) {
        //     adjList[i] = new ArrayList<Integer>();
        // }
        // for (int[] edge: edges) {
        //     adjList[edge[0]].add(edge[1]);
        //     adjList[edge[1]].add(edge[0]);
        // }
        // int[] visited = new int[n];
        // int count = 0;
        // boolean hasCycle = dfs(-1, 0, adjList, visited);
        // if (hasCycle) return false;
        // for (int i = 0; i < n; i++) {
        //     if (visited[i] == 0) return false;
        // }
        return _valid(n, edges);
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
