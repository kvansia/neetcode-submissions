class Solution {
    // Tabulation
    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 0) return 0;
        if(l == 1) return nums[0];

        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < l; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        return dp[l-1];
    }
    // TC O(n) cal once then return from dp
    // SC O(n) dp.length
    

    // REC Approach
    // public int rob(int[] nums) {
    //     int l = nums.length;
    //     if(l == 0) return 0;

    //     int[] dp = new int[l];
    //     int ans = rec(l-1, nums, dp);
    //     return ans;
    // }
    
    // private int rec(int i, int[] nums, int[] dp){
    //     if(i < 0) return 0;
        
    //     if(dp[i] != 0) return dp[i];

    //     // pick or not pick case
    //     int pick = nums[i] + rec(i-2, nums, dp);
    //     int notPick = rec(i-1, nums, dp);

    //     return dp[i] = Math.max(pick, notPick);
    // }
    // TC O(n) cal once then return from dp
    // SC O(n) dp.length + aux stack space
}

