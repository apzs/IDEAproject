public class a4_2_StaticDemo {
    static int b;
    static int m = 10;
    static int n;

    static void method(int a){
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("m=" + m);
        System.out.println("n=" + n);
    }

    static {
        System.out.println("static block is initalized.");
        n = m * 5;
    }

    public static void main(String[] args){
        method(15);
    }
}
