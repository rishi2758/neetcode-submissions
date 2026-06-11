class Solution {
    int[][] dirs = { {-1, 0}, {1, 0}, {0,-1}, {0,1} };

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
                    q.add(new int[] {r, c, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (grid[curr[0]][curr[1]] < curr[2]) continue;

            grid[curr[0]][curr[1]] = curr[2];
            
            for (int[] d : dirs) {
                if (curr[0] + d[0] < 0 ||  curr[1] + d[1] < 0 || curr[0] + d[0] == grid.length ||  curr[1] + d[1] == grid[0].length) continue;
                q.add(new int[] {curr[0] + d[0], curr[1] + d[1], curr[2] + 1});
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
