class Solution {
    public int findDuplicate(int[] nums) {
        int s = nums[0];
        int f = nums[nums[0]];

        while(s != f){
            s = nums[s];
            f = nums[nums[f]];
        }
        
        int s2 = 0;
        while(s2 != s){
            s2 = nums[s2];
            s = nums[s];
        }

        return s;
    }
}
