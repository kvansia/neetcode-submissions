class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        int ans = rec(cost.length, cost, dp);
        return ans;    
    }
    
    private int rec(int i, int[] costs, int[] dp){
        if(i <=1 ) return costs[i];

        if(dp[i] != 0) return dp[i];

        int one = rec(i - 1, costs, dp);
        int two = rec(i - 2, costs, dp);

        if(i == costs.length) return dp[i] = Math.min(one, two);
        return dp[i] = costs[i] + Math.min(one, two);
    }
}

// TC O(n) cal n to 1 or 0 after dp array else 2^n
// SC O(n)  dp array
