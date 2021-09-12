public class MyMain {
    public static void main(String argv){
        System.out.println("Hello cruel world");
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.print( a++);
        System.out.print( a);
        System.out.println(++a);

        int x=2, y=5, k=0;
        switch( x%y ) {
            case 0: k=x+y; break;
            case 1: k=x-y; break;
            case 2: k=x*y; break;
            default: k=x/y; break;
        }
        System.out.println(k);


    }
}
