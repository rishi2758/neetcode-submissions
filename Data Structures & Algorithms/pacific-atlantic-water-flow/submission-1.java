class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // h[r][c] <= h[r-1][c] // atlantic
        // h[r][c] >= h[r+1][c] // pacific
        List<List<Integer>> collect = new ArrayList<>();
        
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int c = 0; c < heights[0].length; c++) {
            find(0, c, heights, pacific);
        }
        for (int r = 0; r < heights.length; r++) {
            find(r, 0, heights, pacific);
        }
        for (int c = 0; c < heights[0].length; c++) {
            find(heights.length-1, c, heights, atlantic);
        }
        for (int r = 0; r < heights.length; r++) {
            find(r, heights[0].length-1, heights, atlantic);
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    collect.add(List.of(r,c));
                }
            }
        }

        return collect;
    }

    private void find(int r, int c, int[][] heights, boolean[][] visited) {
        if (r < 0 || c < 0 || c == heights[0].length || r == heights.length || visited[r][c]) return;

        visited[r][c]=true;

        for (int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length 
    && heights[r][c] <= heights[nr][nc])
                find(nr, nc, heights, visited);
        }
        
    }
}
