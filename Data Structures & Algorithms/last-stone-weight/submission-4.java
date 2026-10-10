class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        // Add all stones in a Priority queue to store the stones according to weight and in max heap so peaking top two stones will give 2 heaviest stones
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int stone : stones){
            pq.add(stone);
        }

        // run awhile loop until the pq size == 1 and return the top val

        while( pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) continue;
            pq.add(Math.abs(a-b));
        }
        return pq.size() > 0 ? pq.peek() : 0;
    }
}

// TC O(nlogn)
