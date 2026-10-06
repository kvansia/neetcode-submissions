class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;

        boolean[][] toatl = new boolean[row][col];
        boolean[][] topes = new boolean[row][col];

        Deque<int[]> p2a = new ArrayDeque<>();
        Deque<int[]> a2p = new ArrayDeque<>();

        for(int r = 0; r < row; r++){
            p2a.add(new int[]{r,0});
            toatl[r][0] = true;
            a2p.add(new int[]{r, col - 1});
            topes[r][col - 1] = true;
        }

        for(int c = 0; c < col; c++){
            p2a.add(new int[]{0,c});
            toatl[0][c] = true;
            a2p.add(new int[]{row -1 ,c});
            topes[row-1][c] = true;
        }

        bfs(p2a, heights, toatl);
        bfs(a2p, heights, topes);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(toatl[r][c] && topes[r][c]){
                    ans.add(Arrays.asList(r,c));
                }
            }
        }    
        return ans;
    }

    private void bfs(Deque<int[]> q, int[][] heights,  boolean[][] bool){
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int row = heights.length;
        int col = heights[0].length;


        while(!q.isEmpty()){
            int[] ind = q.poll();
            int x = ind[0];
            int y = ind[1];

            for(int[] d: dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;

                if(bool[nx][ny]) continue;
                
                if(heights[nx][ny] >= heights[x][y]){
                    bool[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}

// TC O(M*N) fro loop iteration
// SC O(M*N) boolean[][] 
