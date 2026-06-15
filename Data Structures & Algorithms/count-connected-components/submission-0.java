class Solution {
    int component;
    int[] uf;
    int[] size;

    public void init(int n) {
        this.component = n;
        this.uf = new int[n];
        this.size = new int[n];

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

    public int countComponents(int n, int[][] edges) {
        init(n);
        for(int[] edge: edges) {
            union(edge[0], edge[1]);
        }
        return component;
    }
}
