class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i: nums){
            mp.merge(i, 1, Integer::sum);
        }

        int n = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            int val = entry.getValue();
            if(val > n){
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
    // TC O(N)
    // SC O(M) M distinct integer val in nums[]
}