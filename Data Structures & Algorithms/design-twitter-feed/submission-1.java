class Twitter {
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<int[]>> recentTweets;
    private int timestamp = 0;

    public Twitter() {
        recentTweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        recentTweets.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> targetUsers = new HashSet<>(followers.getOrDefault(userId, new HashSet<>()));
        targetUsers.add(userId);
        
        for (int user : targetUsers) {
            List<int[]> tweets = recentTweets.getOrDefault(user, new ArrayList<>());
            for (int[] tweet : tweets) {
                pq.add(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                } 
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(0, pq.poll()[1]);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followers.computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId)
                .remove(followeeId);
        }
    }
}