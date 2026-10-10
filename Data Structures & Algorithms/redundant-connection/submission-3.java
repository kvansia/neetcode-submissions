class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        DisjointSet ds = new DisjointSet(edges.length);
        for(int[] edge: edges){
            // if(!ds.union(edge[0], edge[1])) return edge;
            if(!ds.unionBySize(edge[0], edge[1])) return edge;
        }
        return new int[]{-1,-1};
    }
}

class DisjointSet {
    int[] par;
    int[] rank;
    int[] size; 

    DisjointSet(int n){
        this.par = new int[n+1];
        this.rank = new int[n+1];
        this.size = new int[n+1];
        for(int i = 0 ; i <= n; i++){
            par[i] = i;
        }
    }

    public int findUPar(int node){
        if(par[node] == node) return node;
        return par[node] = findUPar(par[node]);
    }

    public boolean union(int u, int v){
        int ulpu = findUPar(u);
        int ulpv = findUPar(v);

        if(ulpu == ulpv) return false;

        if(rank[ulpu] < rank[ulpv]){
            par[ulpu] = ulpv;
        } else if(rank[ulpu] >= rank[ulpv]){
            par[ulpv] = ulpu;
        } else{
            par[ulpv] = ulpu;
            rank[ulpu]++;
        }
        return true;
    }

    public boolean unionBySize(int u, int v){
        int ulpu = findUPar(u);
        int ulpv = findUPar(v);

        if(ulpu == ulpv) return false;

        if(size[ulpu] > size[ulpv]){
            par[ulpv] = ulpu;
        } else if( size[ulpv] > size[ulpu]){
            par[ulpu] = ulpv;
        } else {
            size[ulpu]++;
            par[ulpv] = ulpu;
        }

        return true;
    }
}

// TC O(1) actually it is 4*alpha but the val of 4Alpha is nearly equal to constant
// SC O(n) size of an par or rank array
