class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1  = 0, can2 = 1;
        int count1 = 0, count2 = 0;

        for(int i : nums){
            if(i == can1){
                count1++;
            } else if(i == can2){
                count2++;
            } else if(count1 == 0){ 
                can1 = i;
                count1 = 1;
            } else if(count2 == 0){
                can2 = i;
                count2 = 1;
            } else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i : nums){
            if(i == can1){
                count1++;
            } else if( i == can2){
                count2++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int check = nums.length / 3;
        if(count1 > check) ans.add(can1);
        if(count2 > check) ans.add(can2);

        return ans;
    }
    // TC O(N)
    // SC O(1)
}