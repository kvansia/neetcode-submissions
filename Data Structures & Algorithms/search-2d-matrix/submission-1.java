class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = (row*col) - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            int nr = m / col;
            int nc = m % col;

            if(matrix[nr][nc] == target){
                return true;
            } else if(matrix[nr][nc] > target ){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}

//TC O(log(row * col)) as we assume the 2D matrix into flatten 1D Array
// SC O(1)
