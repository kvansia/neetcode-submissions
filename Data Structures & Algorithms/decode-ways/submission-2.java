class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        if(s == null  || l == 0) return 0;

        Integer[] memo = new Integer[l];
        int ans = rec(s, 0, memo);

        return ans;
    }

    private int rec(String s, int i, Integer[] memo){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(memo[i] != null) return memo[i];

        int ways = rec(s, i+1, memo);

        // for two int
        if(i+1 < s.length()){
            int d = Integer.parseInt(s.substring(i, i+2));
            if(d >= 10 && d <= 26){
                ways += rec(s,i+2, memo);
            }
        }
        return memo[i] = ways;
    }
}

// TC O(n) cal every value once and stored in memo and returned from there
// SC O(n) memo + aux stack space
