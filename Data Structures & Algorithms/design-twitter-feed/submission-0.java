class Twitter {
    private static int time = 0;

    private class Tweet{
        int postid, time;
        Tweet next;

        Tweet(int pid, int time){
            this.postid = pid;
            this.time = time;
            this.next = null;
        }
    }

    Map<Integer, Tweet> postMap;
    Map<Integer, Set<Integer>> followerMap;
    
    public Twitter() {
        this.postMap = new HashMap<>();
        this.followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, time++);
        if(postMap.containsKey(userId)) newTweet.next = postMap.get(userId);
        postMap.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.time,a.time));

        if(postMap.containsKey(userId)){
            pq.add(postMap.get(userId));
        }

        if(followerMap.containsKey(userId)){
            Set<Integer> followers = followerMap.get(userId);
            for(int f : followers){
                if(postMap.containsKey(f)){
                    pq.add(postMap.get(f));
                }
            }
        }

        while(!pq.isEmpty() && feed.size() < 10){
            Tweet t = pq.poll();
            feed.add(t.postid);

            if(t.next != null){
                pq.add(t.next);
            }
        }

        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followerMap.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId))
        followerMap.get(followerId).remove(followeeId);
    }
}


