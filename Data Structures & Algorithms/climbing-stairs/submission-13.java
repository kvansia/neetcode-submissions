class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n+1];
        return rec(n, dp);
    }
    
    private int rec(int n, Integer[] dp){
        if(n < 0) return 0;
        if(n == 0) return 1;

        // check dp;
        if(dp[n] != null) return dp[n];
        
        // everything in terms of index
        return dp[n] = rec(n-2, dp) + rec(n-1, dp);
    }
}
