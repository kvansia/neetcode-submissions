class Solution {
    public boolean validTree(int n, int[][] edges) {

        // prop of tree which make it distinct from a graph
        // All nodes are connected
        // No cycles

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.put(i, new ArrayList<>());
        }

        // undirected graph so add nodes in both sides
        for(int[] edge: edges){
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
        }

        // to track the status we will add nodes in set
        Set<Integer> st = new HashSet<>();
        
        // Becase every node is connected call isTree once
        if(!isTree(0, -1, mp, st)) return false;

        // To check no node left behind
        return st.size() == n;
    }

    private boolean isTree(int n, int parent, Map<Integer, List<Integer>> mp, Set<Integer> st){
        if(st.contains(n)) return false;

        st.add(n);
        for(int i : mp.get(n)){
            if( i == parent) continue;
            if(!isTree(i, n, mp, st)) return false;
        }

        return true;
    }
}


// TC O(V+E)
// SC O(V+E)
