class Solution {
    public int prefixCount(String[] words, String pref) {
        int len = pref.length(), ans = 0;
        for(String w: words){
            if(w.length() <len) continue;
            int add = 1;
            for(int i = 0; i < len; i++ ){
                if(w.charAt(i) != pref.charAt(i)){
                    add = 0;
                    break;
                }
            }
            ans += add;
        }
        return ans;
    }
}