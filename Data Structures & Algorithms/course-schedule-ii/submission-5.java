class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>>  mp = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            mp.get(pre[0]).add(pre[1]);
        }

        List<Integer> ans = new ArrayList<>();
        int[] status = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, mp, ans, status)) return new int[]{};
        }

        int[] a = new int[ans.size()];
        Arrays.setAll(a, ans::get);
        return a;
    }

    private boolean dfs(int c, Map<Integer, List<Integer>>  mp, List<Integer> ans, int[] status){

        if(status[c] == 1){
            return false;
        }

        if(status[c] == 2){
            // ans.add(c);
            return true;
        }

        status[c] = 1;
        List<Integer> lst = mp.get(c);
        for(Integer l: lst){
            if(!dfs(l, mp, ans, status)) return false;
        }
        
        status[c] = 2;
        ans.add(c);
        return true;
    }
}

// TC O(V + E)
// SC O(V + E)
