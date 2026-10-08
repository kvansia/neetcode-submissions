class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0)  return n;

        // prepare adj list
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i= 0 ; i < n; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
        }

        Set<Integer> st = new HashSet<>();
        int comp = 0;
        for(int i = 0; i < n; i ++){
        // if for loop found any unvisited component increase the counter by 1
            if(!st.contains(i)){
                comp++;
                count(i,-1, mp, st);
            }
        }

        // return the res
        return comp;
    }

    private void count(int n, int par, Map<Integer, List<Integer>> mp, Set<Integer> st){
        if(st.contains(n)) return;

        //  mark the components as vis
        st.add(n);
        for(int i: mp.get(n)){
            if(i == par) continue;
            count(i, n, mp, st);
        }
    }
}

// TC O(V+E)
// SC O(V+E)