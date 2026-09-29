class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeToTarget = new double[target];
        
        for(int i = 0; i < position.length; i++){
            int pos = position[i];
            double t = (double) (target - pos)/ speed[i];
            timeToTarget[pos] = t;
        }

        double maxt = 0.0;
        int flts = 0;
        for(int p = target - 1; p >= 0; p--){
            double t = timeToTarget[p];
            if( t > 0.0 && t > maxt){
                flts++;
                maxt = t;
            }
        }

        return flts;
    }
}
