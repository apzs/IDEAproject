/**
 * @author 无名氏
 * @date 2021/9/12
 */
public  class Test7 {
    static int first = init();

    static int second = 2;

    static int init(){
        return second;
    }

    public static void main(String[] args) {
        System.out.println(first);
    }
}
