class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;

        int[] dp = new int[n+1];

        return rec(n, dp);
    }

    private int rec(int i, int[] dp){
        if(i <= 1) return 1;

        if(dp[i] != 0) return dp[i];

        return dp[i] = rec(i - 1, dp) + rec(i - 2, dp);
    }

}

// TC O(n) 0 to n steps cal one time
// SC O(n) dp array