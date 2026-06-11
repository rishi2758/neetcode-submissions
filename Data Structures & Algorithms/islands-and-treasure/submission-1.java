class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    dfs(r, c, grid, 0);
                }
            }
        }
    }

    private void dfs(int r, int c, int[][] grid, int dist) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == -1 || grid[r][c] < dist) return;
        
        grid[r][c] = dist;
        
        for (int[] d: dirs) {
            dfs(r + d[0], c + d[1], grid, dist+1);
        }
    }
}
