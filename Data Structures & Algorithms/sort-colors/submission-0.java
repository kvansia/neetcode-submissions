class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int j = 0;
        // for(int i = n-1 ; i >= 0; i--){
        for(int i = 0 ; i < n; i++){
            if(nums[i] == 0){
                swap(nums, i, j);
                j++;
            }
        }
        for(int i = j; i < n; i++){
            if(nums[i] == 1){
                swap(nums, i, j);
                j++;
            }
        }
        for(int i = j ; i < n; i++){
            if(nums[i] == 2){
                swap(nums, i, j);
                j++;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}