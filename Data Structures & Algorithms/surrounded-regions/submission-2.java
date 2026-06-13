class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
    /*
        [
            ["O","X","X","O","X"],
            ["X","O","O","X","O"],
            ["X","O","X","O","X"],
            ["O","X","O","O","O"],
            ["X","X","O","X","O"]
        ]
    */
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O')
                dfs(0, c, board);
        }
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O')
                dfs(r, 0, board);
        }
        for (int c = 0; c < m; c++) {
            if (board[board.length-1][c] == 'O')
                dfs(board.length-1, c, board);
        }
        for (int r = 0; r < n; r++) {
            if (board[r][board[0].length-1] == 'O')
                dfs(r, board[0].length-1, board);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'N') board[r][c] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == 'X' || board[r][c] == 'N') return;

        board[r][c] = 'N';

        for (int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(nr, nc, board);
        }
    }
}
