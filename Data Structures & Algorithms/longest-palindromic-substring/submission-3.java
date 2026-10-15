class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(s == null || len == 0) return "";

        int start = 0, end = 0;

        for(int i = 0; i < len ; i++){
            int lodd = isPal(s, i, i);
            int leven = isPal(s, i, i+1);

            int mLen = Math.max(leven, lodd);

            if(mLen > end - start + 1){
                start = i - (mLen - 1) /2;
                end = i + mLen/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int isPal(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l  - 1;
    }
}

// TC O(N^2)
// SC O(1)
