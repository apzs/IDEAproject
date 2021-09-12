import java.util.List;

public class Main {
    public static void main(String[] args) {
        Twitter3 twitter = new Twitter3();
        twitter.postTweet(1, 5);
        // ⽤户 1 发送了⼀条新推⽂ 5
        twitter.getNewsFeed(1);
        // return [5]，因为⾃⼰是关注⾃⼰的
        twitter.follow(1, 2);
        // ⽤户 1 关注了⽤户 2
        twitter.postTweet(2, 6);
        // ⽤户2发送了⼀个新推⽂ (id = 6)
        List<Integer> b = twitter.getNewsFeed(1);
        System.out.println(b.size());
        // return [6, 5]
        // 解释：⽤户 1 关注了  ⾃⼰和⽤户 2，所以返回他们的最近推⽂
        // ⽽且 6 必须在 5 之前，因为 6 是最近发送的
        twitter.unfollow(1, 2);
        // ⽤户 1 取消关注了⽤户 2
        List<Integer> a = twitter.getNewsFeed(1);
        // return [5]
        System.out.println(a.size());

    }
}
