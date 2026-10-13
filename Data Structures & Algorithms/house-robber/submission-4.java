class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 0) return 0;

        int[] dp = new int[l];
        int ans = rec(l-1, nums, dp);
        return ans;
    }
    private int rec(int i, int[] nums, int[] dp){
        if(i < 0) return 0;
        
        if(dp[i] != 0) return dp[i];

        // pick or not pick case
        int pick = nums[i] + rec(i -2, nums, dp);
        int notPick = rec(i-1, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }
    // TC O(n) cal once then return from dp
    // SC O(n) dp.length + aux stack space
}

