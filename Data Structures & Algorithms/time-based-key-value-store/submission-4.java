class TimeMap {
    Map<String, List<Obj>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Obj(timestamp, value));
    }
    
    public String get(String key, int timestamp) { 
        if(map.containsKey(key)){
            return bs(0, map.get(key).size() -1, map.get(key), timestamp);
        } else{
            return "";
        }
    }

    private String bs(int l, int r, List<Obj> lst, int ts){
        String ans = "";
        while(l <= r){
            int mid = l + (r-l)/2;
            if(ts == lst.get(mid).t){
                ans = lst.get(mid).v;
                return ans;
            } else if( ts < lst.get(mid).t){
                r = mid -1;
            } else{
                ans = lst.get(mid).v;
                l = mid + 1;
            }
        }
        return ans;
    }
}

class Obj{
    int t;
    String v;
    public Obj(){};

    public Obj(int t, String v){
        this.t = t;
        this.v = v;
    }
}
