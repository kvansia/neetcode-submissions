class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];
        int maxArea = 0;
        
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1 && !vis[r][c]){
                    int area = rec(r,c,grid, vis);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int rec(int r, int c, int[][] grid, boolean[][] vis){

       if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || vis[r][c]) return 0;

            vis[r][c] = true;
            return 1 + rec(r + 1 , c , grid, vis)
            + rec(r , c + 1, grid, vis)
            + rec(r - 1 , c, grid, vis)
            + rec(r , c - 1, grid, vis);
    }
}

// TC O(M*N)
// SC O(M*N)