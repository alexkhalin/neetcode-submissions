class Twitter {
    private static int FEED_LENGTH = 10;
    private static class Tweet {
        Tweet(int id, int time) { 
            this.id = id;
            this.time = time;
        }
        int id;
        int time;
    }

    private static class User {
        Set<Integer> followees = new HashSet<>();
        Tweet[] tweets = new Tweet[FEED_LENGTH];
        int tweetCnt;
    }

    private static class TweetIterator {
        User user;
        int tweetIdx;

        TweetIterator(User user) {
            this.user = user;
            tweetIdx = user.tweetCnt - 1;
        }
        void next() {
            tweetIdx--;
        }
        Tweet getTweet() {
            return tweetIdx >= 0 && tweetIdx >= user.tweetCnt - FEED_LENGTH 
                ? user.tweets[tweetIdx % FEED_LENGTH] 
                : null; 
        }
    }

    private Map<Integer, User> users = new HashMap<>();
    private int timer = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        users.compute(userId, (uid, user) -> {
            if (user == null) user = new User();
            user.tweets[user.tweetCnt  % FEED_LENGTH] = new Tweet(tweetId, timer++);
            user.tweetCnt++;

            return user;
        });
    }
    
    public List<Integer> getNewsFeed(int userId) {

        User user = users.get(userId);
        if (user == null) return List.of();

        PriorityQueue<TweetIterator> pq = new PriorityQueue<>(user.followees.size() + 1,
            (TweetIterator i1, TweetIterator i2) -> {
                return i2.getTweet().time - i1.getTweet().time;
            });
        
        if (user.tweetCnt != 0) pq.offer(new TweetIterator(user));
        for (Integer followeeId : user.followees){
            User follower = users.get(followeeId);
            if (follower != null && follower.tweetCnt != 0) pq.offer(new TweetIterator(follower));
        }
        List<Integer> tweets = new ArrayList<>(FEED_LENGTH);
        while (tweets.size() < FEED_LENGTH && !pq.isEmpty()) {
            TweetIterator ti = pq.poll();
            tweets.add(ti.getTweet().id);
            ti.next();
            if (ti.getTweet() != null) pq.offer(ti);
        }
        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        users.compute(followerId, (uid, user) -> {
            if (user == null) user = new User();
            user.followees.add(followeeId);
            return user;
        });
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.computeIfPresent(followerId, (uid, user) -> {
            user.followees.remove(followeeId);
            return user;
        });        
    }
}
