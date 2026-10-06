class Solution {
    public int orangesRotting(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int freshFruits = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2) q.add(new int[]{r,c});
                if(grid[r][c] == 1) freshFruits++;
            }
        }

        int time = 0;
        int[][] co = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty() && freshFruits > 0){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] rco = q.poll();
                for(int[] c: co){
                    int nx = rco[0] + c[0];
                    int ny = rco[1] + c[1];

                    if(nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        q.add(new int[]{nx,ny});
                        freshFruits--;  
                    }
                }
            }
            time++;
        }
        return freshFruits == 0 ? time : -1;
    }
}

// TC O(M*N) each element is processed once
// SC O(H) max length of q at any point
