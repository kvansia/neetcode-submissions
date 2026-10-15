class Solution {
    Integer[][] memo;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(s == null || len == 0) return "";
        memo = new Integer[len][len];
        int start = 0, maxLen = 1;

        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(isPal(s, i, j) == 1 && maxLen < j - i + 1){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }

    private int isPal(String s, int l, int r){
        if(l >= r) return 1;

        if(memo[l][r] != null) return memo[l][r];

        if(s.charAt(l) == s.charAt(r) && isPal(s, l+1, r-1) == 1){
            memo[l][r] = 1;
        } else{
            memo[l][r] = 0;
        }

        return memo[l][r];
    }
}

// TC O(n^2)
// SC O(n^2)