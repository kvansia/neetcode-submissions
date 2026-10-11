class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]  frq = new int[26];

        for(char ch: tasks){
            frq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f: frq){
            if(f > 0){
                pq.add(f);
            }
        }

        int totalTime = 0;

        while(!pq.isEmpty()){
            int taskProcessed = 0;
            int cycle = n+1;
            List<Integer> waitlist = new ArrayList<>();

            for(int i = 0; i < cycle; i++){
                if(!pq.isEmpty()){    
                    int maxfreq = pq.poll();
                    taskProcessed++;
                    if(maxfreq > 1){
                        waitlist.add(maxfreq-1);
                    }
                }
            }
            pq.addAll(waitlist);

            totalTime += pq.isEmpty() ? taskProcessed : cycle;
        }

        return totalTime;
    }
}

// TC O(N) for loop Here one thing to consider is that while adding and removing values from pq that is log26 which is fixed no matter what tasks size is. 
// SC O(1) here also k = 26 for pq and int array constant irrespective of input size 