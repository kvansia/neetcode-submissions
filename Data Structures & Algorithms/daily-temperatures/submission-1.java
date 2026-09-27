class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if(temperatures[j] > temperatures[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }
}

// TC O(n^2) 
// SC O(n) Len of temperatures array
