class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int p : piles){
            high = Math.max(high, p);
        }

        int res = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canEat(mid, piles, h)){
                res = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return res;
    }

    private boolean canEat(int bph, int[] piles, int h){
        int totalh = 0;
        for(int p : piles){
            totalh += (int) Math.ceil((double) p / bph);
        }
        return totalh <= h;
    }
}
