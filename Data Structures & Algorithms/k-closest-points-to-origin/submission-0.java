class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Obj> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));

        for(int[] point: points){
            double dist = calDist(point);
            pq.add(new Obj(dist, point));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];        
        for(int i = 0; i < k; i++){
            ans[i] = pq.poll().point;
        }

        return ans;
    }

    private double calDist(int[] point){
        double ans = Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));
        return ans;
    }

}

//  TC O(NLOGK) N LOOP AND K ELE IN PQ
// SC O(N) LEN OF POINTS
class Obj{
    Double dist;
    int[] point;

    Obj(Double dist, int[] point){
        this.dist = dist;
        this.point = point;
    }
}
