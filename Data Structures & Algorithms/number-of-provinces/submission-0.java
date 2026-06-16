class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int res = 0;
        for (int city=0; city < n; city++) {
            if (!visited[city]) {
                dfs(city, isConnected, visited);
                ++res;
            }
        }
        return res;
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