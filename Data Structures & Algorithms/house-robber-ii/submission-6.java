class Solution {
    // Tabulation
    public int rob(int[] nums) {
        int l = nums.length;

        if(l == 0) return 0;
        if(l == 1) return nums[0];

        int zero = trob(nums, 0 , l - 2);
        int one = trob(nums, 1, l - 1);
        
        return Math.max(zero, one);
    }

    private int trob(int[] nums, int s, int e){
        int th = e - s + 1;
        if(th == 1) return nums[s];

        int[] dp = new int[th];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s], nums[s + 1]);

        for(int i = 2; i < th; i++){
            dp[i] = Math.max(dp[i-1] , nums[s + i] + dp[i - 2]);
        } 

        return dp[th -1];
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