class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[][] memo = new int[coins.length][amount + 1];
        
        for(int[] m : memo){
            Arrays.fill(m, -1);
        }

        int res = rec(0, coins, amount, memo);

        return res == Integer.MAX_VALUE ? -1 : res;
    }


    private int rec(int i, int[] coins, int rem, int[][] memo){
        // Success
        if(rem == 0) return 0;
        if(rem < 0 || i >= coins.length) return Integer.MAX_VALUE;

        if(memo[i][rem] != -1) return memo[i][rem];

        // Take
        int take = Integer.MAX_VALUE;
        int resTake = rec(i, coins, rem - coins[i], memo);
        if(resTake != Integer.MAX_VALUE){
            take = 1 + resTake;
        }

        // notTake
        int notTake = rec(i + 1, coins, rem, memo);

        return memo[i][rem] = Math.min(take, notTake);
    }
}
// TC O(M*N) M: number of coins and N : Amount as we use memoization we cal each value once only 
// SC O(M*N) memo [][] + aux stack space