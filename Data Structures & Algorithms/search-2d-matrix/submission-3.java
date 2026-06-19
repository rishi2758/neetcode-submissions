class Solution {
    // 11/2 = 5/1
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n =  matrix[0].length;

        int lo = 0;
        int hi = m*n-1;

        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            int nr = mid/n, nc = mid % n;
            if (matrix[nr][nc] >= target) hi = mid;
            else lo = mid+1;
        }

        if (lo < m*n && matrix[lo/n][lo%n] == target) return true;
        return false;
    }
}
