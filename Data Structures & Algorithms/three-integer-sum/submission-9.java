class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) return ans;

        Arrays.sort(nums);
        int i = 0, n = nums.length, maxV = nums[n - 1];
        if(maxV < 0) return ans;

        while( i < n - 2){
            if(nums[i] > 0) break;
            if(i > 0 && i < n - 2 && nums[i] == nums[i -1]){
                i++;
                continue;
            } 
            
            int l = i + 1;
            int r = n - 1; // 'r' should start at the last index

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    int currentL = nums[l];
                    int currentR = nums[r];

                    // Correct way to fast-forward past duplicate values safely
                    while (l < r && nums[l] == currentL) l++;
                    while (l < r && nums[r] == currentR) r--;
                } else if (sum < 0) {
                    l++; // Sum too small, move left pointer right
                } else {
                    r--; // Sum too large, move right pointer left
                }
            }
            i++;
        }
        return ans;
    }
}
