class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        if(s == null || len == 0) return "";

        int maxLen = 0;
        int[] ind = new int[2];

        for(int i = 0; i  < len; i++){
            char ch = s.charAt(i);
            int r = len -1;
            while( i < r){
                while(ch != s.charAt(r)){
                    r--;
                }
                int lt = i, rt = r; 
                while(lt < rt){
                    if(s.charAt(lt) != s.charAt(rt)){
                        break;
                    }
                    lt++;
                    rt--;
                }
                if(lt >= rt && maxLen < r - i + 1){
                    ind[0] = i;
                    ind[1] = r;
                    maxLen = r - i + 1;
                }
                r--;
            }
        }
        return s.substring(ind[0], ind[1]+1);
    }
}

// TC O(n^2)
// SC O(n)