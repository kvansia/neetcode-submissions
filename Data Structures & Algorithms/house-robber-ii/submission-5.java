class Solution {
    // Tabulation
    public int rob(int[] nums) {
        int l = nums.length;

        if(l == 0) return 0;
        if(l == 1) return nums[0];
        if(l == 2) return Math.max(nums[0], nums[1]);

        int zero = 0, one = 0;
        int[] dp = new int[l+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i <= l - 2; i++){
            dp[i] = Math. max(dp[i-1], nums[i] + dp[i-2]);
        }
        zero = dp[l -2];

        int[] dp2 = new int[l+1];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for(int i = 3; i <= l - 1; i++){
            dp2[i] = Math. max(dp2[i-1], nums[i] + dp2[i-2]);
        }
        one = dp2[l -1];
        
        return Math.max(zero, one);
    }
    // TC O(n)
    // SC O(n)

    // Rec approach
    // public int rob(int[] nums) {
    //     int l = nums.length;

    //     if(l == 0) return 0;
    //     if(l == 1) return nums[0];

    //     int[] dp = new int[l+1];
    //     int zero = rec(nums.length - 2, 0, nums, dp);
        
    //     dp = new int[l+1];
    //     int first = rec(nums.length - 1, 1, nums, dp);
        
    //     return Math.max(zero, first);
    // }

    // private int rec(int i, int f, int[] nums, int[] dp){
    //     if(i < f) return 0;
    //     if(i == f) return nums[i];

    //     if(dp[i] != 0) return dp[i];

    //     int notTake = rec(i-1, f, nums, dp);
    //     int take = nums[i] + rec(i -2, f, nums, dp);

    //     return dp[i] = Math.max(notTake, take);
    // }
// TC O(n)
// SC O(n)

}