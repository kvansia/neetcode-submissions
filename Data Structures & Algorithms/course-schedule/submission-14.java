class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;

        // adj list
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int[] pre: prerequisites){
            mp.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        // dfs
        int[] status = new int[numCourses];

        for(int i = 0; i < numCourses; i ++){
            if(!dfs(i, mp, status)) return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> mp, int[] status){
        if(status[course] == 1) return false;
        if(status[course] == 2) return true;

        status[course] = 1;

        List<Integer> lst = mp.getOrDefault(course, new ArrayList<>());
        for(Integer i: lst){
            if(!dfs(i, mp, status))
                return false;
        }

        status[course] = 2;
        return true;

    }
}

// DAG as a subject depend on the other subject, which should be unidirectional only
// if we find cyclic dependency, we cannot complete all the subjects and return false;
// we check all the courses which has dependency

// We track dependncy using status[] by 0 not started, 1 in-process and 2 completed no cyclic dependency found
// TC O(numOfCourses plus len of map) i.e O(V + E)
// SC O(len of map + max len of list inside each entry) i.e O(V +E)