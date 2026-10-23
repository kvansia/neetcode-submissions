class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null) return  -1;
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
// TC O(nlogn)
// SC O(1)