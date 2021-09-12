public class a4_4_ParamaterDemo {
    public static void main(String[] args) {
        int a = 1;
        Koo k = new Koo();
        add(a);
        add(k);
        int[] ary = {1,2};
        add(ary);
        System.out.println(a + "," + k.a + "," + ary[0]);
    }


    public static int add(int a) {
        return ++a;
    }

    public static int add(Koo koo){
        return ++koo.a;
    }
    public static int add(int[] ary){
        return ++ary[0];
    }
}
    class Koo {
    int a =1;
    }