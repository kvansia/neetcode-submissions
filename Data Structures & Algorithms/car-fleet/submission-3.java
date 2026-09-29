class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) return 0;
        // speed = dist / time
        int flts = 0;
        List<Pair> lst = new ArrayList<>();
        
        for(int i = 0; i < speed.length; i++){
            lst.add(new Pair(position[i], speed[i]));
        }

        lst.sort(Comparator.comparing(Pair::getpos).reversed());
        double maxt = 0.0;
        for(Pair pr: lst){
            double t = (double) (target - pr.pos) / pr.spd;
            if(t > maxt){
                flts++;
                maxt = t;
            }
        }
        return flts;
    }
}

class Pair{
    int pos;
    int spd;
    
    Pair(int pos, int spd){
        this.pos = pos;
        this.spd = spd;
    }

    public int getpos(){
        return pos;
    }
}

// TC: nlogn
// TC: n
