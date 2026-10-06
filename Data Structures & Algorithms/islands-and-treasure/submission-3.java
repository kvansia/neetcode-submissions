class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        // multi start
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col ; c++){
                // fill every 0 into que
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }
        
        int[][] lst = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++ ){
                int[] co = q.poll();

                for(int[] ls: lst){
                    int nx = co[0] + ls[0];
                    int ny = co[1] + ls[1];

                    if(nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 2147483647){
                        grid[nx][ny] = 1 + grid[co[0]][co[1]];
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }        
    }
}
