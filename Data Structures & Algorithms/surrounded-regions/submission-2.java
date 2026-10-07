class Solution {
    public void solve(char[][] board) {
        // bfs
        int row = board.length, col = board[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        for(int r = 0; r < row ; r++){
            if(board[r][0] == 'O') q.add(new int[]{r,0});
            if(board[r][col-1] == 'O') q.add(new int[]{r,col -1});
        }
        for(int c = 0; c < col ; c++){
            if(board[0][c] == 'O') q.add(new int[]{0,c});
            if(board[row-1][c] == 'O') q.add(new int[]{row-1,c});
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] co = q.poll();
            int x = co[0], y = co[1];
            if(board[x][y] != 'O') continue;
            board[x][y] = 'T';

            for(int[] d: dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny] == 'O') {
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for(int r = 0; r <row; r++){
            for(int c = 0; c <col; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }
}
