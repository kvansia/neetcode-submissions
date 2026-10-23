class Solution {
    public int majorityElement(int[] nums) {
       
       int count = 0, cand = 0;

        for(int i : nums){
            if(count == 0){
                cand = i;
                count++;
            } else if( cand == i){
                count++;
            } else{
                count--;
            }
       }
       return cand;
    }

    // TC O(n)
    // SC O(1)

    // public int majorityElement(int[] nums) {
    //     if(nums == null) return  -1;
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }
    // TC O(nlogn)
    // SC O(1)
}