class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer>  mp = new HashMap<>();
        mp.put(0, 1);
        int cSum = 0;
        for(int num: nums){
            cSum += num;

            if(mp.containsKey(cSum - k)){
                ans += mp.get(cSum - k);
            }

            mp.merge(cSum, 1, Integer::sum);
        }

        return ans;
    }
}