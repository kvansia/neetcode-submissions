class Solution {
    // Space optimize
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int prev2 = 1;
        int prev1 = 1;
        int ans =  0;
        
        for(int i = 2; i <= n; i++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
// TC O(n) 0 to n steps cal one time
// SC O(1) 


    // public int climbStairs(int n) {
    //     if(n == 0) return 0;

    //     int[] dp = new int[n+1];
    //     dp[0] = 1;
    //     dp[1] = 1;

    //     for(int i = 2; i <= n; i++){
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }
// TC O(n) 0 to n steps cal one time
// SC O(n) dp array
}
