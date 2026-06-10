class Solution {
    int counter = 0;
    int[][] dirs = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int area = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    counter = 0;
                    dfs(r, c, grid);
                    area = Math.max(area, counter);
                }
            }
        }
        return area;
    }

    private void dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
            return;

        grid[r][c] = 0;
        ++counter;

        for (int[] d : dirs) {
            dfs(r+d[0], c+d[1], grid);
        }
    } 
}
