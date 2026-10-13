class Solution {
    // Space optimization
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length ;
        if(n == 0) return 0;
        if(n <= 2) return Math.min(cost[0], cost[1]);
        
        // int[] dp = new int[n + 1];
        int one = cost[0];
        int two = cost[1];
        int ans = 0;
        for(int i = 2; i <= n; i++){
            if(i == n) ans = Math.min(one, two);
            else ans = cost[i] + Math.min(one, two);
            one = two;
            two = ans;
        
        }
        return ans;    
    }
    // TC O(N)
    // SC O(1)

    // // Tabulation
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length ;
    //     if(n == 0) return 0;
    //     if(n <= 2) return Math.min(cost[0], cost[1]);
        
    //     int[] dp = new int[n + 1];
    //     dp[0] = cost[0];
    //     dp[1] = cost[1];

    //     for(int i = 2; i <= n; i++){
    //         if(i == n) dp[i] = Math.min(dp[i-1], dp[i-2]);
    //         else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    //     }
    //     return dp[n];    
    // }
    // TC O(N)
    // SC O(N)
    

    // public int minCostClimbingStairs(int[] cost) {
    //     int[] dp = new int[cost.length + 1];
    //     int ans = rec(cost.length, cost, dp);
    //     return ans;    
    // }
    
    // private int rec(int i, int[] costs, int[] dp){
    //     if(i <=1 ) return costs[i];

    //     if(dp[i] != 0) return dp[i];

    //     int one = rec(i - 1, costs, dp);
    //     int two = rec(i - 2, costs, dp);

    //     if(i == costs.length) return dp[i] = Math.min(one, two);
    //     return dp[i] = costs[i] + Math.min(one, two);
    // }
// TC O(n) cal n to 1 or 0 after dp array else 2^n
// SC O(n)  dp array
}

