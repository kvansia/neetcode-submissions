class Solution {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;

        for(int r = 0; r < row; r++){
            if(board[r][0] == 'O'){
                dfs(r, 0, board);
            }
            if(board[r][col-1] == 'O'){
                dfs(r, col-1, board);
            }
        }
        for(int c = 0; c < col; c++){
            if(board[0][c] == 'O'){
                dfs(0, c, board);
            }
            if(board[row - 1][c] == 'O'){
                dfs(row - 1, c, board);
            }
        }

        for(int r = 0; r <row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board){
        // Base case
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;
        
        // Change the char
        board[r][c] = 'T';
        System.out.println(r+", "+c);

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] d: dir){
            dfs(r + d[0], c + d[1], board);
        }
    }
}

// TC O(M*N) for loop
// SC O(M*N) aux stack space 