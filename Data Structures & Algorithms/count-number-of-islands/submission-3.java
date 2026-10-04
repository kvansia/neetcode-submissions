class Solution {
    public int numIslands(char[][] grid) {
        // rec as we need to check all coordinates
        int row = grid.length;
        int col = grid[0].length;
        boolean vis[][] = new boolean[row][col];
        int numI = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1' && !vis[r][c]){
                    numI += 1;
                    vis[r][c] = true;
                    rec(r,c,grid, vis);
                }
            }
        }

        return numI;
    }

    private void rec(int r, int c, char[][] grid, boolean[][] vis){
        List<int[]> pc = helper(r, c, grid, vis);

        for(int[] cord: pc){
            vis[cord[0]][cord[1]] = true;
            rec(cord[0], cord[1], grid, vis);
        }

    }

    private List<int[]> helper(int r, int c, char[][] grid, boolean[][] vis){
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        List<int[]> ans = new ArrayList<>();

        for(int[] cord: dirs){
            int nx = r + cord[0];
            int ny = c + cord[1];

            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1' && !vis[nx][ny]){
                ans.add(new int[]{nx, ny});
            }
        }
        return ans;
    }
}

// TC O(M*N) for loop
// SC O(M*N) vis[][] can be optimised by changing inplace grid[][]
