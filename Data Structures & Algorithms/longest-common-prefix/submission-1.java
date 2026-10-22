class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String base = strs[0];

        for(int i = 0; i < base.length(); i++){
            char ch =  base.charAt(i);

            for(int j = 1; j < strs.length; j++){
                String w = strs[j];
                if(w.length() == i || ch != w.charAt(i)){
                    return base.substring(0,i);
                }
            }
        }
        return base;

    }
}

// TC O(base.length() * strs.length)
// SC O(1)