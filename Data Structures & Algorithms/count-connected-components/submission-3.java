class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0)  return n;

        // prepare adj list
        List<Integer>[] lst = new ArrayList[n];
        for(int i= 0 ; i < n; i++){
            lst[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            lst[edge[0]].add(edge[1]);
            lst[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        int comp = 0;
        for(int i = 0; i < n; i ++){
        // if for loop found any unvisited component increase the counter by 1
            if(!vis[i]){
                comp++;
                count(i,-1, lst, vis);
            }
        }

        // return the res
        return comp;
    }

    private void count(int n, int par, List<Integer>[] lst, boolean[] vis ){
        if(vis[n]) return;

        //  mark the components as vis
        vis[n] = true;
        for(int i: lst[n]){
            if(i == par) continue;
            count(i, n, lst, vis);
        }
    }
}

// TC O(V+E)
// SC O(V+E)