class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r){

        if( l < r){
            int m = (l + (r - l)/2);

            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);

            merge(nums, l ,m ,r);
        }
    }

    private void merge(int[] nums, int l, int m, int r){
        int l1 = m - l + 1;
        int l2 = r - m;

        int[] d1 = new int[l1]; 
        int[] d2 = new int[l2]; 
        
        for(int i = 0; i < l1; i++){
            d1[i] = nums[l + i];
        }
        for(int i = 0; i < l2; i++){
            d2[i] = nums[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;
        while(i < l1 && j < l2){
            if(d1[i] <= d2[j]){
                nums[k] = d1[i];
                i++;
            } else {
                nums[k] = d2[j];
                j++;
            }
            k++;
        }

        while(i < l1){
            nums[k] = d1[i];
            i++;
            k++;
        }
        while(j < l2){
            nums[k] = d2[j];
            j++;
            k++;
        }
    }
}

// TC O(nlogn)
// SC O(n)