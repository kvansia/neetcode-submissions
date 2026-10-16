class Solution {
    // Iterative, Bottom UP: Tabular
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[][] memo = new int[coins.length][amount + 1];

        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                memo[0][i] = i / coins[0];
            } else{
                memo[0][i] = Integer.MAX_VALUE;
            }
        }

        for(int coin = 1; coin < coins.length; coin++){
            for(int tar = 0; tar <= amount; tar++){
                int nonTake = memo[coin - 1][tar];
                int take = Integer.MAX_VALUE; 
                      
                if (tar >= coins[coin]) {
                    int resTake = memo[coin][tar - coins[coin]];
                    if(resTake != Integer.MAX_VALUE){
                        take = 1 + resTake;
                    }
                }

                memo[coin][tar] = Math.min(nonTake, take);
            }
        }

        return memo[coins.length -1][amount] == Integer.MAX_VALUE ? -1 : memo[coins.length -1][amount];
    }
    // TC O(M*N)
    // SC O(M*N)

    // Recurssive 
    // public int coinChange(int[] coins, int amount) {
    //     if(amount == 0) return 0;

    //     int[][] memo = new int[coins.length][amount + 1];
        
    //     for(int[] m : memo){
    //         Arrays.fill(m, -1);
    //     }

    //     int res = rec(0, coins, amount, memo);

    //     return res == Integer.MAX_VALUE ? -1 : res;
    // }


    // private int rec(int i, int[] coins, int rem, int[][] memo){
    //     // Success
    //     if(rem == 0) return 0;
    //     if(rem < 0 || i >= coins.length) return Integer.MAX_VALUE;

    //     if(memo[i][rem] != -1) return memo[i][rem];

    //     // Take
    //     int take = Integer.MAX_VALUE;
    //     int resTake = rec(i, coins, rem - coins[i], memo);
    //     if(resTake != Integer.MAX_VALUE){
    //         take = 1 + resTake;
    //     }

    //     // notTake
    //     int notTake = rec(i + 1, coins, rem, memo);

    //     return memo[i][rem] = Math.min(take, notTake);
    // }
}
// TC O(M*N) M: number of coins and N : Amount as we use memoization we cal each value once only 
// SC O(M*N) memo [][] + aux stack space