import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class b_1116_打印0与奇偶数 {
    private int n;

    public b_1116_打印0与奇偶数(int n) {
        this.n = n;
    }

    Semaphore zeros=new Semaphore(1);
    Semaphore odds=new Semaphore(0);
    Semaphore evens=new Semaphore(0);

    //线程 A 将调用 zero()，它只输出 0 。
    //线程 B 将调用 even()，它只输出偶数。
    //线程 C 将调用 odd()，它只输出奇数。
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int i=0;
        while(i<n){
            zeros.acquire();
            printNumber.accept(0);
            if((i+2)%2==0){
                odds.release();
            }else{
                evens.release();
            }
            i++;
        }
    }
    //打印偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        int i=0;
        while(i<n/2){
            evens.acquire();
            printNumber.accept(i*2+2);
            i++;
            zeros.release();
        }
    }
    //打印奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        int i=0;
        while(i<(n+1)/2){
            odds.acquire();
            printNumber.accept(i*2+1);
            i++;
            zeros.release();
        }
    }

    public static void main(String[] args) {
        b_1116_打印0与奇偶数 zeroEvenOdd = new b_1116_打印0与奇偶数(5);
        new Thread(()->{
            try {
                zeroEvenOdd.zero(value -> {
                    System.out.print(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.even(value -> {
                    System.out.print(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.odd(value -> {
                    System.out.print(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
