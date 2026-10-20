class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();

        for(String word : wordDict){
            st.add(word);
        }

        Boolean[] dp = new Boolean[s.length()];

        boolean ans = rec(s, 0, st, dp);
        return ans;
    }

    private boolean rec(String s, int i, Set<String> st, Boolean[] dp){
        if( i == s.length()) return true;

        if(dp[i] != null) return dp[i];

        for(int e = i + 1; e <= s.length(); e++){
            String substn = s.substring(i,e);
            if(st.contains(substn) && rec(s, e, st, dp)) return dp[i] = true;
        }

        return dp[i] = false;
    }
}

// TC O(N^2 * L) for loop and substring of max length L
// SC O(N) : size of hashSet and aux rec stack space