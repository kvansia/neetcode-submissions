class Solution {
    public int findKthLargest(int[] nums, int k) {
        // I use min heap as we store k  elements and 
        //  if any large element come to the pq the smallest 
        // element on the top will be removed and 
        // it keeps the large element in the heap
        // As heap poll() method always remove what is on the top of pq
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}

// TC O(NlogK)
// SC O(k+1)