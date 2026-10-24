class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
    if(matrix == null || matrix.length == 0) return;
    
    int r = matrix.length;
    int c = matrix[0].length;
    
    dp = new int[r+1][c+1];
    for(int i = 1; i <= r; i++){
        for(int j = 1; j <= c; j++){
            dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
        }
    }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1  = row1 + 1;
        int r2  = row2 + 1;
        int c1  = col1 + 1;
        int c2  = col2 + 1;
        return dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */