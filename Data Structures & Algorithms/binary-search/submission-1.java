class Solution {
    public int search(int[] nums, int target) {
        int ans = bs(0, nums.length-1, nums, target);
        return ans;
    }

    private int bs(int l, int r, int[] nums, int t){
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == t){
                return mid;
            } else if( nums[mid] < t){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
