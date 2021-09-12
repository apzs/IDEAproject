public class a4_3_OverloadDemo {
    public static void main(String[] args){
        a4_3_Foo f = new a4_3_Foo();
        System.out.println(f.add(1,1));
        System.out.println(f.add('0',1));
        System.out.println(f.add(1L,1));
    }
}
