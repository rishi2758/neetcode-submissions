class Solution {
    int[] uf;
    int[] size;
    int province;

    public void init(int n) {
        this.uf = new int[n];
        this.size = new int[n];
        this.province = n;

        for (int i = 0; i < n; i++) {
            uf[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA == rootB) return false;

        --province;
        if (size[a] < size[b]) {
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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        init(n);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (isConnected[r][c] == 1) {
                    union(r, c);
                }
            }
        }
        return province;

        // boolean[] visited = new boolean[n];
        // int res = 0;
        // for (int city=0; city < n; city++) {
        //     if (!visited[city]) {
        //         dfs(city, isConnected, visited);
        //         ++res;
        //     }
        // }
        // return res;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        if (visited[city]) return;
        visited[city] = true;
        for (int adj=0; adj < isConnected.length; adj++) { 
            if (isConnected[city][adj] == 1) {
                dfs(adj, isConnected, visited);
            }
        }
    }
}