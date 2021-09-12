import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1.创建一个线程
        ExecutorService es = Executors.newFixedThreadPool(2);
        //2.创建一个类，实现一个Runnable接口
        //3.调用 ExecutorService 中的 submit 方法，传递线程任务(实现类)，开启线程，执行run方法。
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        //线程池一直开启，使用完线程后，会自动归还给线程池，可以继续启用。
        //销毁线程
        es.shutdown();
    }
}
