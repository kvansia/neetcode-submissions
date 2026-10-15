class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(s == null || len == 0) return 0;

        int ans = 0;
        for(int i = 0; i < len; i++){
            ans += isPal(s, i, i) + isPal(s, i, i+1);
        }

        return ans;
    }

    private int isPal(String s, int l, int r){
        int ans = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            ans++;
        }

        return ans;
    }
}

// TC O(N^2)
// SC O(1);
