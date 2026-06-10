class Solution {
    int[][] dirs = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int area = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, dfs(r, c, grid));
                }
            }
        }
        return area;
    }

    private int dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;
        int size = 1;
        for (int[] d : dirs) {
            size += dfs(r+d[0], c+d[1], grid);
        }
        return size;
    } 
}
