class Solution {
    int[][] dirs = { {-1, 0}, {1, 0}, {0,-1}, {0,1} };
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        // int n = grid.length;
        // int m = grid[0].length;
        // for (int r = 0; r < n; r++) {
        //     for (int c = 0; c < m; c++) {
        //         if (grid[r][c] == 0) {
        //             dfs(r, c, grid, 0);
        //         }
        //     }
        // }
        solve(grid);
    }

    public void solve(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0;  c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[] {r, c});
                }
            }
        }
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();

                for (int[] d : dirs) {
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];

                    if (nr < 0 || nc < 0 || nr == grid.length ||  nc == grid[0].length) continue;
                    if (grid[nr][nc] != INF) continue;

                    grid[nr][nc] = dist;
                    q.add(new int[] {nr, nc});
                }
            }
            ++dist;
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
