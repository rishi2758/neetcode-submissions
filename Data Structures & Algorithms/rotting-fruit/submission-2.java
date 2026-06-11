class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int EMPTY = 0;
    int FRESH = 1;
    int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int freshOrange = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ROTTEN) {
                    q.add(new int[] {r, c});
                }
                if (grid[r][c] == FRESH) {
                    ++freshOrange;
                }
            }
        }

        if (freshOrange == 0) return 0;

        int time = -1;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] dir: dirs) {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];

                    if (nr < 0 || nc < 0 || nr == grid.length || nc == grid[0].length) continue;
                    if (grid[nr][nc] == EMPTY || grid[nr][nc] == ROTTEN) continue;

                    grid[nr][nc] = ROTTEN;
                    ++count;
                    q.add(new int[] {nr, nc});
                }
            }
            ++time;
        }

        return count == freshOrange ? time : -1;
    }
}
