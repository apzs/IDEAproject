import java.util.*;

public class Twitter {
    private static int timestamp = 0;
    // 我们需要⼀个映射将 userId 和 User 对象对应起来
    private HashMap<Integer, User> userMap = new HashMap<>();
    // user 发表⼀条 tweet 动态
    public void postTweet(int userId,int tweetId){
        //若userId不存在，则创建
        if (!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
            User u = userMap.get(userId);
            u.post(tweetId);
        }
    }
    // follower 关注 followee
    public void follow(int followerId,int followeeId){
        //若follower不存在，则创建
        if (!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if (!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    // follower 取关 followee，如果 Id 不存在则什么都不做
    public void unfollow(int followerId,int followeeId){

    }
    //返回该 user 关注的⼈（包括他⾃⼰）最近的动态 id，
    //最多 10 条，⽽且这些动态必须按从新到旧的时间线顺序排列。
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)){
            return null;
        }
        Set<Integer> users = userMap.get(userId).followed;
        //自动通过time属性从大到小排序,容量为userId的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(),(a,b)->(b.time-a.time));
        //先将所有链表头节点插⼊优先级队列
        for (int id : users){
            Tweet twt = userMap.get(id).head;
            if (twt == null){
                continue;
            }
            pq.add(twt);
        }
        while (!pq.isEmpty()){
            if (res.size() == 10){
                break;
            }
            //弹出 time 值最⼤的（最近发表的）
            Tweet twt = pq.poll();
            res.add(twt.id);
            //将下一篇Tweet插入进行排序
            if (twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }

    /**
     * 推文
     */

    class User{
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            follow(id);
        }
        //关注
        public void follow(int userId) {
            followed.add(userId);
        }
        //取关
        public void unfollow(int userId){
            if (userId!=this.id){
                followed.remove(userId);
            }
        }
        //发文
        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId,timestamp);
            timestamp++;
            twt.next = head;
            head = twt;
        }
    }
    class Tweet{
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
}
